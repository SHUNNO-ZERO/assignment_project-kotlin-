package com.asif.mvp_mvp.feature.food_details.view

import com.asif.mvp_mvp.feature.food_details.model.Food_new

interface FoodDetailsView_new {
    fun handleProgressBarVisibility_new(visibility: Int)
    fun onFoodDetailsFetchSuccess_new(foodNew: Food_new)
    fun onFoodDetailsFetchFailure_new(errorMessage: String)
}