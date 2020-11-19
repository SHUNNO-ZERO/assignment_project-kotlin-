package com.asif.mvp_mvp.feature.food_list.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_item_food_new.view.*

class FoodViewHolder_new(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val iv_food_new : ImageView = itemView.iv_food_new
    val tv_food_name_new: TextView = itemView.tv_food_name_new
    val tv_price_value_new : TextView = itemView.tv_price_value_new
    val iv_favorite_new : ImageView = itemView.iv_favorite_new
}