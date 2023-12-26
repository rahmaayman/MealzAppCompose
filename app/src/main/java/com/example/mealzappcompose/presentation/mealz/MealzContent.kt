package com.example.mealzappcompose.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mealzappcompose.presentation.mealz.MealzState

@Composable
fun Mealz(
    state: MealzState,
    modifier: Modifier = Modifier,
    navController: NavController
){
    state.categoryResponse?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = "Mealz",
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(content = {
                items(data.categories){
                    MealCard(category = it, backgroundColor = Color.White, navController = navController)
                }
            })

        }
    }

    
}
