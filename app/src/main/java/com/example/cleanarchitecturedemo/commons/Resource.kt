package com.example.cleanarchitecturedemo.commons

sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    // states of progress bar are declared here

    class Success<T>(data: T) : Resource<T>(data)

    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)


    class Loading<T>(data: T? = null) : Resource<T>(data)
}