package com.asif.mvp_mvp.feature.food_list.model

import com.asif.mvp_mvp.feature.food_details.model.Food_new
import com.asif.mvp_mvp.network.FoodApiInterface_new
import com.asif.mvp_mvp.network.RetrofitClient_new
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodListModelNewImpl_new: FoodListModel_new {

    private val apiInterface_new = RetrofitClient_new.getClient_new().create(FoodApiInterface_new::class.java)
    private val call_new = apiInterface_new.getFoodlistNew()

    override fun getFoodList_new(foodListCallbackNew: FoodListCallback_new) {

        call_new.enqueue(object : Callback<MutableList<Food_new>>{

            override fun onResponse(call: Call<MutableList<Food_new>>, response: Response<MutableList<Food_new>>) {
                response.body()?.let {
                    foodListCallbackNew.onSuccess_new(it)
                }
            }

            override fun onFailure(call: Call<MutableList<Food_new>>, t: Throwable) {
                foodListCallbackNew.onError_new(t)
            }

        })
    }
}