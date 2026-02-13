package com.example.kotlinfiap

import android.os.Bundle
import android.telecom.Connection
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
            .background(color = Color(0x9E000000))
    ) {
        Card(
            modifier = Modifier
                .width(180.dp)
                .height(90.dp)
                .align(Alignment.TopEnd),
            shape = RoundedCornerShape(
                bottomStart = 85.dp
            ),
            colors = CardDefaults
                .cardColors(
                    containerColor = Color(0xFF4A5CBD)
                )
        ) {}
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(R.drawable.bot),
                contentDescription = "Astro Bot posing",
                modifier = Modifier
                    .size(240.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                Text(
                    text = "THE GREATEST APP OF ALL TIME",
                    fontSize = 16.sp,
                    color = Color(0xFF4A5CBD),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Is Under Development",
                    fontSize = 54.sp,
                    lineHeight = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top =14.dp, bottom = 18.dp),
                    textAlign = TextAlign.Center
                )

                Row{
                    Button(
                        onClick = {},
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = Color(0xFFED1459)
                            ),
                        border = BorderStroke(
                            width = 1.dp,
                            color = Color(0xFFFFC107)
                        ),

                    ) {
                        Text(
                            text = "Take Red Pill",
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = {},
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = Color(0xFF25327A)
                            ),
                        border = BorderStroke(
                            width = 1.dp,
                            color = Color(0xFFD2CECE)
                        ),
                    ) {
                        Text(
                            text = "Take Blue Pill" ,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )

                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .width(180.dp)
                .height(90.dp)
                .align(Alignment.BottomStart),
            shape = RoundedCornerShape(
                topEnd = 85.dp
            ),
            colors = CardDefaults
                .cardColors(
                    containerColor = Color(0xFF4A5CBD)
                )
        ) {}
    }
}

@Composable
@Preview
fun InitialScreenPreview() {
    KotlinfiapTheme {
        InitialScreen()
    }
}
