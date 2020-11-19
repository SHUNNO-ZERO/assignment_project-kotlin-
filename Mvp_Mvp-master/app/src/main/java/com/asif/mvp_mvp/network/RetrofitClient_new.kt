package com.asif.mvp_mvp.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient_new {

    private const val BASE_URL_new = "https://raw.githubusercontent.com/"  //adress

    private val gson_new = GsonBuilder().setLenient().create()

    private val retrofit_new = Retrofit.Builder()
        .baseUrl(BASE_URL_new)
        .addConverterFactory(GsonConverterFactory.create(gson_new))
        .build()

    fun getClient_new(): Retrofit {
        return retrofit_new
    }
}