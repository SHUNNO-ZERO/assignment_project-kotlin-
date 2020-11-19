package com.asif.mvp_mvp.feature.food_list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.asif.mvp_mvp.R
import com.asif.mvp_mvp.feature.food_details.model.Food_new

class FoodListAdapter_new(val foodNewList_new: MutableList<Food_new>, val itemClickListenerNew: ItemClickListener_new) : RecyclerView.Adapter<FoodViewHolder_new>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder_new {
        val view_new = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_food_new, parent, false)
        return FoodViewHolder_new(view_new)
    }

    override fun onBindViewHolder(holderNew: FoodViewHolder_new, position: Int) {
        val food_new = foodNewList_new[position]

        Glide.with(holderNew.iv_food_new)
            .load(food_new.imageUrl)
            .into(holderNew.iv_food_new)
        holderNew.tv_food_name_new.text = food_new.name
        holderNew.tv_price_value_new.text = holderNew.itemView.context.getString(R.string.tk, food_new.price)

        holderNew.itemView.setOnClickListener {
            itemClickListenerNew.onItemClicked_new(position)
        }
    }

    override fun getItemCount(): Int {
        return foodNewList_new.size
    }

}