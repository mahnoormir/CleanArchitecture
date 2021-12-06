package com.example.cleanarchitecturedemo.presentation.meal_search

import com.example.cleanarchitecturedemo.commons.Resource
import com.example.cleanarchitecturedemo.domain.model.Meal

data class MealSearchState(
    val data:List<Meal> ?= null,
    val error:String = "",
    val isLoading: Boolean = false

){

}
