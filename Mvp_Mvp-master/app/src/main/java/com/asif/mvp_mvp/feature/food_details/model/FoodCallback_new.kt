package com.asif.mvp_mvp.feature.food_details.model

interface FoodCallback_new {
    fun onSuccess_new(foodNew: Food_new)
    fun onError_new(errorMessage_new: Throwable)
}