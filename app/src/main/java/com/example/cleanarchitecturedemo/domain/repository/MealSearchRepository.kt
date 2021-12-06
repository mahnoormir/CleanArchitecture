package com.example.cleanarchitecturedemo.domain.repository

import com.example.cleanarchitecturedemo.data.model.MealsDTO

interface MealSearchRepository {
    suspend fun getMealList(s:String):MealsDTO
}