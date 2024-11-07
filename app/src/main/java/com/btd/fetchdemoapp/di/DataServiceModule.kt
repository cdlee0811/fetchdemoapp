package com.btd.fetchdemoapp.di

import com.btd.fetchdemoapp.DataRepository
import com.btd.fetchdemoapp.service.DataApiService
import com.btd.fetchdemoapp.service.DataRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataServiceModule {

    @Singleton
    @Provides
     fun provideDataRepository(dataApiService: DataApiService): DataRepository = DataRepositoryImpl(dataApiService)

}

@Module
@InstallIn(SingletonComponent::class)
object DataNetworkModule {
    private val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    @Provides
    @Singleton
    fun provideRetrofitObject(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun createDataService(retrofit: Retrofit): DataApiService =
        retrofit.create(DataApiService::class.java)
}