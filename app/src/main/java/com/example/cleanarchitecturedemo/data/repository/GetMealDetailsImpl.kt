package com.example.cleanarchitecturedemo.data.repository

import com.example.cleanarchitecturedemo.data.model.MealsDTO
import com.example.cleanarchitecturedemo.data.remote.MealSearchAPI
import com.example.cleanarchitecturedemo.domain.repository.GetMealDetailsRepository

class GetMealDetailsImpl(private val mealSearchAPI: MealSearchAPI): GetMealDetailsRepository {
    override suspend fun getMealDetails(id: String): MealsDTO {
        return mealSearchAPI.getMealDetails(id)
    }
}