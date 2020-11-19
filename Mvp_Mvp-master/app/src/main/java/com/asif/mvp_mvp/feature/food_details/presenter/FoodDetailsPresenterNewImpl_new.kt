package com.asif.mvp_mvp.feature.food_details.presenter

import com.asif.mvp_mvp.feature.food_details.model.Food_new
import com.asif.mvp_mvp.feature.food_details.model.FoodCallback_new
import com.asif.mvp_mvp.feature.food_details.model.FoodDetailsModel_new
import com.asif.mvp_mvp.feature.food_details.model.FoodDetailsModelNewImpl_new
import com.asif.mvp_mvp.feature.food_details.view.FoodDetailsView_new

class FoodDetailsPresenterNewImpl_new(private val viewNew: FoodDetailsView_new): FoodDetailsPresenter_new {

    val modelNew : FoodDetailsModel_new = FoodDetailsModelNewImpl_new()
    val VISIBLE_new = 0 // View.VISIBLE = 0
    val GONE_new = 8 // View.GONE = 8

    override fun getFoodDetails_new() {

        viewNew.handleProgressBarVisibility_new(VISIBLE_new)

        modelNew.getFoodDetails_new(object : FoodCallback_new {

            override fun onSuccess_new(foodNew: Food_new) {
                viewNew.handleProgressBarVisibility_new(GONE_new)
                viewNew.onFoodDetailsFetchSuccess_new(foodNew)
            }

            override fun onError_new(errorMessage_new: Throwable) {
                viewNew.handleProgressBarVisibility_new(VISIBLE_new)
                if (errorMessage_new.localizedMessage != null)
                    viewNew.onFoodDetailsFetchFailure_new(errorMessage_new.localizedMessage!!)
                else
                    viewNew.onFoodDetailsFetchFailure_new("Something is wrong..")
            }
        })
    }
}