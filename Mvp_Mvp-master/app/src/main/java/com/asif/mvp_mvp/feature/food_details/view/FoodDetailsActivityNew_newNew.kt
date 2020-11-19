package com.asif.mvp_mvp.feature.food_details.view

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.asif.mvp_mvp.R

import com.asif.mvp_mvp.core.BaseActivity_new
import com.asif.mvp_mvp.feature.food_details.model.Food_new
import com.asif.mvp_mvp.feature.food_details.presenter.FoodDetailsPresenter_new
import com.asif.mvp_mvp.feature.food_details.presenter.FoodDetailsPresenterNewImpl_new
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_food_details_new.*
import kotlinx.android.synthetic.main.activity_toolbar_new.*

class FoodDetailsActivityNew_newNew : BaseActivity_new(), FoodDetailsView_new {

    override fun setLayoutId_new(): Int = R.layout.activity_food_details_new
    override fun setToolbar_new(): Toolbar {
        toolbar_new.title = getString(R.string.list_of_bangladeshi_list)
        return toolbar_new
    }
    override val isHomeUpButtonEnable_new: Boolean get() = true

    private lateinit var presenterNew : FoodDetailsPresenter_new

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenterNew = FoodDetailsPresenterNewImpl_new(this)

        presenterNew.getFoodDetails_new()
    }

    override fun handleProgressBarVisibility_new(visibility: Int) {
        progressBar_new.visibility = visibility
    }

    override fun onFoodDetailsFetchSuccess_new(foodNew: Food_new) {

        Glide.with(iv_food_new)
            .load(foodNew.imageUrl)
            .into(iv_food_new)
        tv_food_name_new.text = foodNew.name
        tv_price_value_new.text = getString(R.string.tk,foodNew.price)
        tv_description_new.text = foodNew.description
    }

    override fun onFoodDetailsFetchFailure_new(errorMessage_new: String) {

        showToast(errorMessage_new)

        Logger.e(errorMessage_new)
    }

}