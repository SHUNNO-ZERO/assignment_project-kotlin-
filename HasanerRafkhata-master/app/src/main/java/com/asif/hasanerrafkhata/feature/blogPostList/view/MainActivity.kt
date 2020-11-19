package com.asif.hasanerrafkhata.feature.blogPostList.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.asif.hasanerrafkhata.R
import com.asif.hasanerrafkhata.core.BaseActivity
import com.asif.hasanerrafkhata.core.ItemClickListener
import com.asif.hasanerrafkhata.feature.blogPost.presenter.BlogPostPostActivity
import com.asif.hasanerrafkhata.feature.blogPostList.model.BlogPostList
import com.asif.hasanerrafkhata.feature.blogPostList.presenter.BlogPostListPresenter
import com.asif.hasanerrafkhata.feature.blogPostList.presenter.BlogPostListPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity() : BaseActivity(), BlogPostListView {

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun toolbar(): Toolbar {
        toolbar.title = "হাসানের রাফখাতা "
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean get() = false
    private lateinit var presenterPost : BlogPostListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenterPost = BlogPostListPresenterImpl(this)
        presenterPost.getBlogPostList()

    }

    override fun progressBarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress.visibility = View.VISIBLE
        else
            progress.visibility = View.GONE
    }

    override fun blogListRetrieveSuccess(blogPostListList: MutableList<BlogPostList>) {
        initAdapter(blogPostListList)
    }

    override fun blogFetchSuccess(blogPostList: BlogPostList) {
        ////////////////////           ////////////////////////////
    }

    private fun initAdapter(blogPostListList: MutableList<BlogPostList>) {
        val adapter = BlogPostListAdapter(blogPostListList, object : ItemClickListener {
            override fun itemClick(position: Int) {
                val id = blogPostListList[position].id
                val intent = Intent(this@MainActivity, BlogPostPostActivity::class.java)
                intent.putExtra("value",id)
                startActivity(intent)
            }

        })
        recyclerViewId.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerViewId.adapter = adapter

    }

    override fun blogListRetrieveFailure(errorMessage: String) {
        showToast(errorMessage)
    }
}