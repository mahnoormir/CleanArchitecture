package com.example.cleanarchitecturedemo.domain.use_case

import com.example.cleanarchitecturedemo.commons.Resource
import com.example.cleanarchitecturedemo.data.model.toDomainMeal
import com.example.cleanarchitecturedemo.data.model.toDomainMealDetails
import com.example.cleanarchitecturedemo.domain.model.Meal
import com.example.cleanarchitecturedemo.domain.model.MealDetails
import com.example.cleanarchitecturedemo.domain.repository.GetMealDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class GetMealDetailsUseCase @Inject constructor(private val repository: GetMealDetailsRepository){
    operator fun invoke(id:String):Flow<Resource<MealDetails>> = flow {

        try {

            //show progress bar until data is loading
            emit(Resource.Loading())
            val response = repository.getMealDetails(id).meals[0].toDomainMealDetails()
            emit(Resource.Success(data=response))

        }
        catch (e: HttpException){
            emit(Resource.Error(message = e.localizedMessage?: "Unknown error"))
        }
        catch (e: IOException){
            emit(Resource.Error(message = e.localizedMessage?: "Check your Internet connection"))
        }
        catch (e: Exception){
        }
    }
}