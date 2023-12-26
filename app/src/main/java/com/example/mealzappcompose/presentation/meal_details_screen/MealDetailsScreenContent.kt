package com.example.mealzappcompose.presentation.meal_details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun MealDetailsScreenContent(
    mealState: MealState,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(state = scrollState),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(
            modifier = modifier.fillMaxWidth(),
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = mealState.strCategoryThumb),
                contentDescription = mealState.strCategoryThumb,
                modifier = modifier.fillMaxWidth()
                    .height(250.dp)
                    .padding(16.dp),
                contentScale = ContentScale.FillWidth
            )
        }

        Text(
            text = mealState.strCategory,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = mealState.strCategoryDescription,
            fontSize = 18.sp
        )

    }
}