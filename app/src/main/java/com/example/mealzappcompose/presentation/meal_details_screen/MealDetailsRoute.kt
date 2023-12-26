package com.example.mealzappcompose.presentation.meal_details_screen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mealzappcompose.presentation.MealDetailsScreen
import com.example.mealzappcompose.presentation.meal_details_screen.MealDetailsArgs.Companion.STR_CATEGORY_ARGS
import com.example.mealzappcompose.presentation.meal_details_screen.MealDetailsArgs.Companion.STR_CATEGORY_DESCRIPTION_ARGS
import com.example.mealzappcompose.presentation.meal_details_screen.MealDetailsArgs.Companion.STR_CATEGORY_THUMB_ARGS
import com.example.mealzappcompose.presentation.util.Screen

fun NavController.navigateToMealsDetailsScreen(
    strCategoryThumb:String,
    strCategory:String,
    strCategoryDescription:String
){
    navigate(
        route = "${Screen.MealDetailsScreen.route}/${strCategoryThumb}/${strCategory}/${strCategoryDescription}"
    )

}

fun NavGraphBuilder.mealDetailsRoute(
    navController: NavController
) {
    composable(
        route = "${Screen.MealDetailsScreen.route}/{${STR_CATEGORY_THUMB_ARGS}}/{${STR_CATEGORY_ARGS}}/{${STR_CATEGORY_DESCRIPTION_ARGS}}",
        arguments = listOf(
            navArgument(STR_CATEGORY_THUMB_ARGS){ NavType.StringType},
            navArgument(STR_CATEGORY_ARGS){ NavType.StringType},
            navArgument(STR_CATEGORY_DESCRIPTION_ARGS){ NavType.StringType}
        )
    ){
        MealDetailsScreen(navController=navController)
    }
}

class MealDetailsArgs(
    savedStateHandle: SavedStateHandle
) {
    val strCategoryThumb:String = checkNotNull(savedStateHandle[STR_CATEGORY_THUMB_ARGS])
    val strCategory:String = checkNotNull(savedStateHandle[STR_CATEGORY_ARGS])
    val strCategoryDescription:String = checkNotNull(savedStateHandle[STR_CATEGORY_DESCRIPTION_ARGS])

    companion object{
        const val STR_CATEGORY_THUMB_ARGS = "strCategoryThumb"
        const val STR_CATEGORY_ARGS = "strCategory"
        const val STR_CATEGORY_DESCRIPTION_ARGS = "strCategoryDescription"
    }
}
