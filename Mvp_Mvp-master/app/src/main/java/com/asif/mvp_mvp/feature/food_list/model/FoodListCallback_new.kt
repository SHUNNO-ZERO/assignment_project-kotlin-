package com.asif.mvp_mvp.feature.food_list.model

import com.asif.mvp_mvp.feature.food_details.model.Food_new

interface FoodListCallback_new {
    fun onSuccess_new(foodNewList: MutableList<Food_new>)
    fun onError_new(throwable: Throwable)
}