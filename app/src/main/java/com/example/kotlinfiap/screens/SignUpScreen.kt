package com.example.kotlinfiap.screens

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinfiap.R
import com.example.kotlinfiap.ui.theme.KotlinfiapTheme

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
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
                .fillMaxWidth()
                .align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleComponent()
            ProfileImage()
            SignUpUserForm()
        }
    }
}

@Preview (
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun SignUpScreenPreview () {
    KotlinfiapTheme {
        SignUpScreen()
    }
    
}

@Composable
fun TitleComponent(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.sign_up),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(R.string.create_account),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview (
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun TitleComponentPreview() {
    KotlinfiapTheme{
        TitleComponent()
    }
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .size(120.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = stringResource(R.string.profile_image),
            modifier = Modifier
                .size(110.dp)
                .align(alignment = Alignment.Center)
        )
        Icon(
            imageVector = Icons.Default.AddAPhoto,
            contentDescription = stringResource(R.string.add_photo_icon),
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
        )
    }
}

@Preview (showBackground = true)
@Composable
private fun ProfileImagePreview() {
    KotlinfiapTheme {
        ProfileImage()
    }
    
}

@Composable
fun SignUpUserForm(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        //Username input field
        OutlinedTextField(
            value = "",
            onValueChange = {},
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
                    focusedTextColor = MaterialTheme.colorScheme.primary,
                    unfocusedTextColor = MaterialTheme.colorScheme.onBackground
                ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = stringResource(R.string.person_icon),
                    tint = MaterialTheme.colorScheme.tertiary

                )
            }
        )
        // user email
        OutlinedTextField(
            value = "",
            onValueChange = {},
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
                focusedTextColor = MaterialTheme.colorScheme.primary,
                unfocusedTextColor = MaterialTheme.colorScheme.onBackground
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Mail,
                    contentDescription = stringResource(R.string.email_icon),
                    tint = MaterialTheme.colorScheme.tertiary

                )
            }
        )
        //Password field
        OutlinedTextField(
            value = "",
            onValueChange = {},
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
                focusedTextColor = MaterialTheme.colorScheme.primary,
                unfocusedTextColor = MaterialTheme.colorScheme.onBackground
            ),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = stringResource(R.string.lock_icon),
                    tint = MaterialTheme.colorScheme.tertiary

                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.RemoveRedEye,
                    contentDescription = stringResource(R.string.eye_icon),
                    tint = MaterialTheme.colorScheme.tertiary

                )
            }
        )
        Spacer(modifier = Modifier.padding(32.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults
                .buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary
                ),
            border = BorderStroke(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSurface
            ),

            ) {
            Text(
                text = stringResource(R.string.button_sign_up),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpUserFormPreview() {
    KotlinfiapTheme() {
        SignUpUserForm()
    }
}