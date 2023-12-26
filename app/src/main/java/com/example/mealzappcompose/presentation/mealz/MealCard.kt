package com.example.mealzappcompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.domain.data.Category
import com.example.mealzappcompose.presentation.meal_details_screen.navigateToMealsDetailsScreen
import com.example.mealzappcompose.presentation.ui.theme.CardBackgroundColor
import com.example.mealzappcompose.presentation.util.Screen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun MealCard(
    category: Category,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Card(
        backgroundColor = backgroundColor,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .padding(16.dp)
            .clickable {
                val imageUrl =
                    URLEncoder.encode(category.strCategoryThumb, StandardCharsets.UTF_8.toString())
                navController
                    .navigateToMealsDetailsScreen(
                        strCategoryThumb = imageUrl,
                        strCategory = category.strCategory,
                        strCategoryDescription = category.strCategoryDescription
                    )

            },
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = category.strCategoryThumb),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .padding(16.dp),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = category.strCategory,
                fontSize = 20.sp,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }

}