package com.asif.mvp_mvp.feature.food_list.presenter

import com.asif.mvp_mvp.feature.food_details.model.Food_new
import com.asif.mvp_mvp.feature.food_list.model.FoodListModel_new
import com.asif.mvp_mvp.feature.food_list.model.FoodListModelNewImpl_new
import com.asif.mvp_mvp.feature.food_list.view.FoodListView_new
import com.asif.mvp_mvp.feature.food_list.model.FoodListCallback_new

class FoodListPresenterNewImpl_new(private val viewNew: FoodListView_new): FoodListPresenter_new {

    private val modelNew: FoodListModel_new = FoodListModelNewImpl_new()

    override fun getFoodList_new() {

        viewNew.handleProgressBarVisibility_new(true)

        modelNew.getFoodList_new(object : FoodListCallback_new {

            override fun onSuccess_new(foodNewList: MutableList<Food_new>) {
                viewNew.handleProgressBarVisibility_new(false)
                viewNew.onFoodListFetchSuccess_new(foodNewList)
            }

            override fun onError_new(throwable: Throwable) {
                viewNew.handleProgressBarVisibility_new(false)
                if (throwable.localizedMessage != null)
                    viewNew.onFoodListFetchFailure_new(throwable.localizedMessage!!)
                else
                    viewNew.onFoodListFetchFailure_new("Something went wrong")
            }

        })
    }
}