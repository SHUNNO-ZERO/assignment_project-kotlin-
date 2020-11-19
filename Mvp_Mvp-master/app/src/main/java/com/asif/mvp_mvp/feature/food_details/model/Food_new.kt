package com.asif.mvp_mvp.feature.food_details.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Food_new (
        val id: Int,
        val name: String,
        val price: Int,
        val discount: Int,
        val isFavorite: Boolean,
        val imageUrl: String,
        val rating: Float,
        val description: String,
        @SerializedName("restaurantName_") val resturant: String
): Serializable