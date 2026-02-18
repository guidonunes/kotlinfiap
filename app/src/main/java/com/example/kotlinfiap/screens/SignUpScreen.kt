package com.example.kotlinfiap.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinfiap.ui.theme.KotlinfiapTheme

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {

}

@Composable
fun TitleComponent(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Sign Up"
        )
        Text(
            text = "Create New Account"
        )
    }
}

@Preview
@Composable
private fun TitleComponentPreview() {
    KotlinfiapTheme{
        TitleComponent()
    }
}