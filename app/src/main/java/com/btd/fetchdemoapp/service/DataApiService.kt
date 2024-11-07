package com.btd.fetchdemoapp.service

import com.btd.fetchdemoapp.model.DataModel
import retrofit2.Response
import retrofit2.http.GET

interface DataApiService {
    @GET("hiring.json")
    suspend fun getData(): Response<List<DataModel>>
}