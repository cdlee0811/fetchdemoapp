package com.btd.fetchdemoapp.model

sealed class DataResult<out T>

class Success<out T>(val data: List<DataModel>) : DataResult<T>()

class ApiResponseError(val message: String) : DataResult<Nothing>()