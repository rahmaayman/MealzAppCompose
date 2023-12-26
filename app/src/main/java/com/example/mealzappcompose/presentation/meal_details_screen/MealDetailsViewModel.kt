package com.example.mealzappcompose.presentation.meal_details_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzappcompose.presentation.mealz.MealzState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(MealState())
        private set

    private val args = MealDetailsArgs(savedStateHandle)

    init {
        state = state.copy(
            strCategoryThumb = args.strCategoryThumb,
            strCategory = args.strCategory,
            strCategoryDescription = args.strCategoryDescription
        )
    }

}