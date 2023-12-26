package com.example.mealzappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mealzappcompose.presentation.mealz.MealzViewModel
import com.example.mealzappcompose.presentation.ui.theme.MealzAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MealzViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzApp()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppComposeTheme {

    }
}