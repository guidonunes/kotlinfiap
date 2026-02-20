package com.example.kotlinfiap.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinfiap.R
import com.example.kotlinfiap.ui.theme.KotlinfiapTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            topBar = {},
            bottomBar = {},
            floatingActionButton = {},

        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
            ) {

            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    KotlinfiapTheme() {
        HomeScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Row() {
                Column() {
                    Text(
                        text = "Hello, John Doe!",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "johndoe@email.com",
                        style = MaterialTheme.typography.displaySmall
                    )
                }
                Card(
                    shape = CircleShape,
                    colors = CardDefaults
                        .cardColors()
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = "User image"
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun MyTopAppBarPreview() {
    KotlinfiapTheme() {
        MyTopAppBar()
    }
}