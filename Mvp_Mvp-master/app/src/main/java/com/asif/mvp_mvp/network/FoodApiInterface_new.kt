package com.asif.mvp_mvp.network

import com.asif.mvp_mvp.feature.food_details.model.Food_new
import retrofit2.Call
import retrofit2.http.GET

interface FoodApiInterface_new {

    @GET("hasancse91/android-course-v2/master/09_Android_MVP_Architecture/data/foodlist.json")
    fun getFoodlistNew(): Call<MutableList<Food_new>>

    @GET("hasancse91/android-course-v2/master/09_Android_MVP_Architecture/data/food.json")

    fun getFoodDetailsnew(): Call<Food_new>
}