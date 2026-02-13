package com.example.kotlinfiap

import android.os.Bundle
import android.telecom.Connection
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinfiap.ui.theme.KotlinfiapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinfiapTheme {

            }
        }
    }
}

@Composable
fun InitialScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .background(color = Color.Gray)
        ){
            Image(
                painter = painterResource(R.drawable.bot),
                contentDescription = "Astro Bot posing",
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(color = Color.Green)
            ){
                Text(
                    text = "THE GREATEST APP OF ALL TIME",
                    fontSize = 16.sp,
                    color = Color.Cyan,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Is Being Developed!",
                    fontSize = 64.sp,
                    lineHeight = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Row{
                    Button(
                        onClick = {}
                    ) {
                        Text(
                            text = "Take Red Pill",

                        )
                    }
                    Button(
                        onClick = {}
                    ) {
                        Text(
                            text = "Take Blue Pill"
                        )

                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun InitialScreenPreview() {
    KotlinfiapTheme {
        InitialScreen()
    }
}
