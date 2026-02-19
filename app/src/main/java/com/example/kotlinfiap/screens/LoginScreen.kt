package com.example.kotlinfiap.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinfiap.R
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
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)

    ) {
        Text(
            text = stringResource(R.string.log_in),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = stringResource(R.string.login_greeting),
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleSmall
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

@Composable
fun LogInForm(modifier: Modifier = Modifier) {
    
}