package com.example.kotlinfiap.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinfiap.ui.theme.KotlinfiapTheme

@Composable
fun LoginScreen (modifier: Modifier = Modifier) {
    
}


@Preview
@Composable
private fun LoginScreenPreview () {
    KotlinfiapTheme() {
        LoginScreen()
    }
}

@Composable
fun LoginTitle(modifier: Modifier = Modifier) {
    Column() {
        Text(
            text = "Log In",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge
        )
    }
    
}

@Preview(showBackground = true)
@Composable
private fun LogInTitlePreview() {
    KotlinfiapTheme() {
        LoginTitle()
    }
    
}
