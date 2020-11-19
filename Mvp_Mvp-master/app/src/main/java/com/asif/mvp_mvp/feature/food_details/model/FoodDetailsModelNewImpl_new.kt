package com.asif.mvp_mvp.feature.food_details.model

import com.asif.mvp_mvp.network.FoodApiInterface_new
import com.asif.mvp_mvp.network.RetrofitClient_new
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodDetailsModelNewImpl_new: FoodDetailsModel_new {

    private val apiInterface_new = RetrofitClient_new.getClient_new().create(FoodApiInterface_new::class.java)
    private val call_new = apiInterface_new.getFoodDetailsnew()

    override fun getFoodDetails_new(foodCallbackNew: FoodCallback_new) {

        call_new.enqueue(object : Callback<Food_new> {

            override fun onResponse(call: Call<Food_new>, response: Response<Food_new>) {
                response.body()?.let {
                    foodCallbackNew.onSuccess_new(it)
                }
            }

            override fun onFailure(call: Call<Food_new>, t: Throwable) {
                foodCallbackNew.onError_new(t)
            }

        })
    }
}