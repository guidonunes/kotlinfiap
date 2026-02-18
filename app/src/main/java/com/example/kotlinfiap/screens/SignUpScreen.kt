package com.example.kotlinfiap.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinfiap.R
import com.example.kotlinfiap.ui.theme.KotlinfiapTheme

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {

}

@Composable
fun TitleComponent(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(R.string.sign_up)
        )
        Text(
            text = stringResource(R.string.create_account)
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