package com.example.kotlinfiap.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kotlinfiap.model.ConsoleUsed

import com.example.kotlinfiap.repository.saveReviewConsoleUsed
import com.example.kotlinfiap.ui.theme.KotlinfiapTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddReviewConsoleUsedScreen(
    navController: NavHostController?,
    reviewId: Int?,
    reviewTitle: String?
) {

    var methods = remember {
        mutableStateListOf<ConsoleUsed>()
    }

    var method by remember {
        mutableStateOf("")
    }

    var methodNumber by remember {
        mutableIntStateOf(0)
    }

    val scope = rememberCoroutineScope()

    var newMethods: List<ConsoleUsed> by remember {
        mutableStateOf(listOf())
    }

    // Função lambda para preparar e enviar
    // os dados para o servidor
    val saveNewMethods: () -> Unit = {
        println("Saving new methods...")
        scope.launch {
            val methodsToSend = methods.map{
                it.copy(id = null)
            }
            newMethods = saveReviewConsoleUsed(
                reviewId = reviewId!!,
                consoleUsed = methodsToSend
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme
                    .colorScheme.background
            )
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            TopEndCard(modifier = Modifier.align(Alignment.TopEnd))
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Step 3...",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "Let's add the console/platform used to play the game.",
                            color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(
                        top = 2.dp,
                        bottom = 8.dp
                    )
                )
                Text(
                    text = reviewTitle.toString(),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.FormatListNumbered,
                        contentDescription = "Add box",
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Console Used",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                // Campo título da receita
                OutlinedTextField(
                    value = method,
                    onValueChange = { method = it },
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                        ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.tertiary
                        )
                    },
                    placeholder = {
                        Text(text = "Instructions step here...")
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                methodNumber = methods.size + 1
                                methods.add(ConsoleUsed(methodNumber, method))
                                method = "" // Limpa o campo após adicionar
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.AddCircle,
                                contentDescription = "Add button",
                                tint = Color(0xFF4CAF50)
                            )
                        }
                    }
                )
            }
            Column(
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
                    .weight(2f)
            ) {
                LazyColumn {
                    items(
                        items = methods,
                        key = { it.hashCode() } // Usando hashcode como chave estável para os itens
                    ) { method ->
                        ConsoleUsedItem(
                            onClick = {
                                methods.remove(method)

                                // Atualizamos a ordem dos métodos de preparo
                                val reorderedList = methods.mapIndexed { index, item ->
                                    item.copy(id = index + 1)
                                }
                                // Atualizamos a lista de modos de preparo
                                methods.clear()
                                methods.addAll(reorderedList)
                            },
                            consoleUsed = method
                        )
                    }
                }
            }

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                TextButton(
                    onClick = saveNewMethods
                ) {
                    Text(
                        text = "NEXT",
                        style = MaterialTheme.typography.titleSmall,
                        fontSize = 28.sp
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Next button"
                    )
                }
            }

        }

    }
}

@Composable
fun ConsoleUsedItem(
    onClick: () -> Unit, consoleUsed: ConsoleUsed
) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth(),
        colors = CardDefaults
            .cardColors(
                containerColor = MaterialTheme
                    .colorScheme.primary
            )
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(), // Alterado de fillMaxSize para fillMaxWidth
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .border(
                        width = 2.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
                    .background(
                        color = MaterialTheme.colorScheme.tertiary,
                        shape = CircleShape
                    )
            ) {
                Text(
                    text = consoleUsed.id.toString(),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            Text(
                text = consoleUsed.description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(2f)
            )
            IconButton(
                onClick = {
                    onClick()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete preparation method",
                    tint = MaterialTheme.colorScheme.tertiary,
                )
            }
        }
    }
}

@Preview
@Composable
private fun ConsoleUsedItemPreview() {
    KotlinfiapTheme() {
        ConsoleUsedItem(
            onClick = {},
            consoleUsed = ConsoleUsed(22, "Teste")
        )
    }
}

@Preview
@Composable
private fun AddReviewConsoleUsedScreenPreview() {
    KotlinfiapTheme() {
        AddReviewConsoleUsedScreen(
            navController = null,
            reviewId = 0,
            reviewTitle = "Recipe name")
    }
}