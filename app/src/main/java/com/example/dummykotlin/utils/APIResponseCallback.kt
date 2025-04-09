package com.example.dummykotlin.utils

sealed class APIResponseCallback<T> {

    class Failed<T>(val message: String) : APIResponseCallback<T>()
    class Success<T>(val data: T) : APIResponseCallback<T>()
    class Loading<T> : APIResponseCallback<T>()
    companion object {
        fun <T> loading() = Loading<T>()
        fun <T> failed(message: String) = Failed<T>(message)
        fun <T> success(data:T) = Success<T>(data)
    }


}