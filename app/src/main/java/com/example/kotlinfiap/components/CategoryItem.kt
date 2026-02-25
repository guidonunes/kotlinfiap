package com.example.kotlinfiap.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinfiap.model.Category
import com.example.kotlinfiap.ui.theme.KotlinfiapTheme

@Composable
fun CategoryItem(category: Category = Category()) {
    Column(

    ) {
        Card() { }
        Text(
            text = category.name
        )
    }
}

@Preview
@Composable
private fun CategoryItemPreview() {
    KotlinfiapTheme() {
        CategoryItem()
    }
}