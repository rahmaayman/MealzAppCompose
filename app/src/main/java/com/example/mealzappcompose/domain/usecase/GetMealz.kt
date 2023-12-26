package com.example.domain.usecase

import com.example.domain.repo.MealzRepo

class GetMealz(private val mealzRepo: MealzRepo) {

    suspend operator fun invoke() = mealzRepo.getMealzFromRemote()
}
// talama 3andy fun wa7da gowa el class momken a3ml operator fun w beltaly lma agy a3ml GetMealz() by3ml call ll operator fun el gowa