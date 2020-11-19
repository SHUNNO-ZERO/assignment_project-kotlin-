package com.asif.mvp_mvp.feature.food_list.view

import com.asif.mvp_mvp.feature.food_details.model.Food_new

interface FoodListView_new {
    fun handleProgressBarVisibility_new(isVisible_new: Boolean)
    fun onFoodListFetchSuccess_new(foodNewList_new: MutableList<Food_new>)
    fun onFoodListFetchFailure_new(errorMessage_new: String)
}