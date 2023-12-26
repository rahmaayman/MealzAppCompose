package com.example.mealzappcompose.presentation.mealz

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repo.MealzRepo
import com.example.mealzappcompose.domain.util.Resource
import com.example.mealzappcompose.presentation.mealz.MealzState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealzViewModel @Inject constructor(
    private val mealzRepo: MealzRepo
) : ViewModel() {

    var state by mutableStateOf(MealzState())
        private set

    init {
        getMealz()
    }

    private fun getMealz(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            when(val result = mealzRepo.getMealzFromRemote()){
                is Resource.Success -> {
                    state = state.copy(
                        categoryResponse = result.data,
                        isLoading = false,
                        error = null
                    )
                }

                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        error = "Couldn't retrieve Mealz."
                    )
                }
            }
        }
    }
}