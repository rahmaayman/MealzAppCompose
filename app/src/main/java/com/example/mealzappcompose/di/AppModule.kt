package com.example.mealzappcompose.di

import com.example.data.remote.ApiService
import com.example.data.repo.MealzRepoImp
import com.example.domain.repo.MealzRepo
import com.example.domain.usecase.GetMealz
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRepo(apiService: ApiService): MealzRepo {
        return MealzRepoImp(apiService)
    }

    @Provides
    fun provideUseCase(mealzRepo: MealzRepo): GetMealz {
        return GetMealz(mealzRepo)
    }

}