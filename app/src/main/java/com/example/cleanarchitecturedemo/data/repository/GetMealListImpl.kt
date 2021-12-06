package com.example.cleanarchitecturedemo.data.repository

import com.example.cleanarchitecturedemo.data.model.MealsDTO
import com.example.cleanarchitecturedemo.data.remote.MealSearchAPI
import com.example.cleanarchitecturedemo.domain.repository.MealSearchRepository

class GetMealListImpl(private val mealSearchAPI: MealSearchAPI ) : MealSearchRepository  {
    override suspend fun getMealList(s: String): MealsDTO {
        return mealSearchAPI.getMealList(s)
    }
}