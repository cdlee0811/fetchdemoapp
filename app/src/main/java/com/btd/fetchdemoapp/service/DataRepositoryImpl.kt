package com.btd.fetchdemoapp.service

import com.btd.fetchdemoapp.DataRepository
import com.btd.fetchdemoapp.model.ApiResponseError
import com.btd.fetchdemoapp.model.DataModel
import com.btd.fetchdemoapp.model.DataResult
import com.btd.fetchdemoapp.model.Success
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepositoryImpl @Inject constructor(private val dataService: DataApiService) :
    DataRepository {
    override suspend fun getData(): DataResult<List<DataModel>> {
        return try {
            val response = dataService.getData()
            if (response.isSuccessful) {
                Success(response.body() ?: emptyList())
            } else {
                ApiResponseError("")
            }

        } catch (e: Exception) {
            ApiResponseError(e.message ?: "Unknown Error")
        }
    }
}