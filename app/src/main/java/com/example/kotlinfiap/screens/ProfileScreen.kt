package com.example.kotlinfiap.screens

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Patterns
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kotlinfiap.R
import com.example.kotlinfiap.model.User
import com.example.kotlinfiap.navigation.Destination
import com.example.kotlinfiap.repository.RoomUserRepository
import com.example.kotlinfiap.ui.theme.KotlinfiapTheme
import com.example.kotlinfiap.utils.convertBitmapToByteArray

@Composable
fun ProfileScreen (navController: NavController, email: String?) {
        val context = LocalContext.current

        val placeholderImage = BitmapFactory
            .decodeResource(
                Resources.getSystem(),
                android.R.drawable.ic_menu_gallery
            )

        var profileImage by remember {
            mutableStateOf<Bitmap>(placeholderImage)
        }

        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent(),
        ) { uri ->
            if (Build.VERSION.SDK_INT < 28) {
                profileImage = MediaStore
                    .Images
                    .Media
                    .getBitmap(
                        context.contentResolver,
                        uri
                    )
            } else {
                if (uri != null) {
                    val source = ImageDecoder
                        .createSource(context.contentResolver, uri)
                    profileImage = ImageDecoder
                        .decodeBitmap(source)
                } else {
                    profileImage = placeholderImage
                }
            }

        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    MaterialTheme.colorScheme.background
                )
        ) {
            TopEndCard(modifier = Modifier.align(alignment = Alignment.TopEnd))
            BottomStartCard(modifier = Modifier.align(alignment = Alignment.BottomStart))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(alignment = Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                ProfileTitleComponent()
                Spacer(modifier = Modifier.height(46.dp))
                ProfileUserImage(profileImage, launcher)
                ProfileUserForm(navController, profileImage, email)
            }
        }

}

@Preview
@Composable
private fun ProfileScreenPreview() {
    KotlinfiapTheme() {
        ProfileScreen(rememberNavController(), "")
    }
}

@Composable
fun ProfileTitleComponent(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.profile),
            color = MaterialTheme.colorScheme.onTertiary,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(R.string.user_data_information),
            color = MaterialTheme.colorScheme.onTertiary,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Composable
fun ProfileUserImage(profileImage: Bitmap, launcher: ManagedActivityResultLauncher<String, Uri?>) {
    Box(
        modifier = Modifier
            .size(120.dp)
    ) {
        Image(
            bitmap = profileImage.asImageBitmap(),
            contentDescription = stringResource(R.string.profile_image),
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(110.dp)
                .align(alignment = Alignment.Center),
            contentScale = ContentScale.Crop
        )
        Icon(
            imageVector = Icons.Default.AddAPhoto,
            contentDescription = stringResource(R.string.add_photo_icon),
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
                .clickable(
                    onClick = {
                        launcher.launch("image/*")
                    }
                )
        )
    }
}

@Composable
fun ProfileUserForm(navController: NavController, profileImage: Bitmap, userEmail: String?) {
//    val userRepository = RoomUserRepository(context = LocalContext.current)
    val userRepository = RoomUserRepository(context = LocalContext.current)
    var user = userRepository.getUserByEmail(userEmail!!)

    var name by remember { mutableStateOf(user!!.name) }
    var email by remember { mutableStateOf(user!!.email) }
    var password by remember { mutableStateOf(user!!.password) }

    var isNameError by remember { mutableStateOf(false) }
    var isEmailError by remember { mutableStateOf(false) }
    var isPasswordError by remember { mutableStateOf(false) }

    var showDialogError by remember { mutableStateOf(false) }
    var showDialogSuccess by remember { mutableStateOf(false) }


    fun validate(): Boolean {
        isNameError = name.length < 3
        isEmailError = email.length < 3 || !Patterns.EMAIL_ADDRESS.matcher(email).matches()
        isPasswordError = password.length < 3
        return !isNameError && !isEmailError && !isPasswordError
    }


//    val userRepository = SharedPreferencesUserRepository(context = LocalContext.current)


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        //Username input field
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = stringResource(R.string.your_name),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.
            colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                unfocusedTextColor = MaterialTheme.colorScheme.onBackground
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(R.string.person_icon),
                    tint = MaterialTheme.colorScheme.secondary

                )
            },
            isError = isNameError,
            trailingIcon = {
                if (isNameError) {
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Error",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },
            supportingText = {
                if (isNameError) {
                    Text(
                        text = "Name must be at least 3 characters",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }
        )
        // user email
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = stringResource(R.string.your_email),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.
            colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                unfocusedTextColor = MaterialTheme.colorScheme.onBackground
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Mail,
                    contentDescription = stringResource(R.string.email_icon),
                    tint = MaterialTheme.colorScheme.secondary

                )
            },
            isError = isEmailError,
            trailingIcon = {
                if (isEmailError) {
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Error",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },
            supportingText = {
                if (isEmailError) {
                    Text(
                        text = "Email must be at least 3 characters",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }
        )
        //Password field
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = stringResource(R.string.your_password),
                    style = MaterialTheme.typography.labelSmall
                )
            },
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.
            colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onBackground,
                unfocusedTextColor = MaterialTheme.colorScheme.onBackground
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = stringResource(R.string.lock_icon),
                    tint = MaterialTheme.colorScheme.secondary

                )
            },
            isError = isPasswordError,
            trailingIcon = {
                if (isPasswordError) {
                    Icon(
                        imageVector = Icons.Default.Error,
                        contentDescription = "Error",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },
            supportingText = {
                if (isPasswordError) {
                    Text(
                        text = "Password must be at least 3 characters",
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End
                    )
                }
            }
        )
        Spacer(modifier = Modifier.padding(32.dp))
        Button(
            onClick = {
                if (validate()) {
                    val updatedRows = userRepository.update(
                        User(
                            id = user!!.id,
                            name = name,
                            email = email,
                            password = password,
                            userImage = convertBitmapToByteArray(profileImage)
                        )
                    )
                    showDialogSuccess = updatedRows > 0
                    showDialogError = updatedRows == 0
                } else {
                    showDialogError = true
                }

            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults
                .buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSurface
            ),

            ) {
            Text(
                text = stringResource(R.string.update_profile),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
    if(showDialogSuccess) {
        AlertDialog(
            onDismissRequest = {
                showDialogError = false
            },
            title = {
                Text(text = "Success")
            },
            text = {
                Text(text = "Profile updated successfully")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialogSuccess = false
                        navController.navigate(Destination.LoginScreen.route)
                    }
                ) {
                    Text(text = "OK")
                }
            }

        )
    }

    if (showDialogError) {
        AlertDialog(
            onDismissRequest = {
                showDialogError = false

            },
            title = {
                Text(text = "Error")
            },
            text = {
                Text(text = "Please fill in all fields")
            },
            confirmButton = {
                TextButton(
                    onClick= {
                        showDialogError = false
                    }
                ) {
                    Text(text = "OK")
                }
            }
        )
    }
}
