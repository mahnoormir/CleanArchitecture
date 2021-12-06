package com.example.cleanarchitecturedemo.domain.repository

import com.example.cleanarchitecturedemo.data.model.MealsDTO

interface GetMealDetailsRepository {
    suspend fun getMealDetails(id:String): MealsDTO
}