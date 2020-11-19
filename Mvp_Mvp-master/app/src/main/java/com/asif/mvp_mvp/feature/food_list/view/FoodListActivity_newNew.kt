package com.asif.mvp_mvp.feature.food_list.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.asif.mvp_mvp.R
import com.asif.mvp_mvp.core.BaseActivity_new
import com.asif.mvp_mvp.feature.food_details.model.Food_new
import com.asif.mvp_mvp.feature.food_details.view.FoodDetailsActivityNew_newNew
import com.asif.mvp_mvp.feature.food_list.presenter.FoodListPresenter_new
import com.asif.mvp_mvp.feature.food_list.presenter.FoodListPresenterNewImpl_new
import kotlinx.android.synthetic.main.activity_food_list_new.*
import kotlinx.android.synthetic.main.activity_toolbar_new.*

class FoodListActivity_newNew : BaseActivity_new(), FoodListView_new {

    override fun setLayoutId_new(): Int {
        return R.layout.activity_food_list_new
    }
    override fun setToolbar_new(): Toolbar {
        toolbar_new.title = getString(R.string.list_of_bangladeshi_list)
        return toolbar_new
    }
    override val isHomeUpButtonEnable_new: Boolean get() = false

    private lateinit var presenterNew: FoodListPresenter_new

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenterNew = FoodListPresenterNewImpl_new(this)

        presenterNew.getFoodList_new()
    }

    override fun handleProgressBarVisibility_new(isVisible_new: Boolean) {
        if (isVisible_new)
            progress_new.visibility = View.VISIBLE
        else
            progress_new.visibility = View.GONE
    }

    override fun onFoodListFetchSuccess_new(foodNewList_new: MutableList<Food_new>) {
        initFoodAdapter(foodNewList_new)
    }

    override fun onFoodListFetchFailure_new(errorMessage_new: String) {
        showToast(errorMessage_new)
    }

    private fun initFoodAdapter(foodNewList_new: MutableList<Food_new>) {

        val adapter = FoodListAdapter_new(foodNewList_new, object : ItemClickListener_new {

            override fun onItemClicked_new(position: Int) {
                startActivity(Intent(this@FoodListActivity_newNew, FoodDetailsActivityNew_newNew::class.java))
            }

        })
        recyclerView_new.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView_new.adapter = adapter
    }

}