package com.example.cleanarchitecturedemo.presentation.meal_details

import com.example.cleanarchitecturedemo.domain.model.MealDetails

data class MealDetailsState(
    val isLoading: Boolean = false,
    val data: MealDetails? = null,
    val error: String = ""
) {
}