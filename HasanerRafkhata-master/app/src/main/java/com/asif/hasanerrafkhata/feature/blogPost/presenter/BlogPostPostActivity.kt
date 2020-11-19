package com.asif.hasanerrafkhata.feature.blogPost.presenter

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.asif.hasanerrafkhata.R
import com.asif.hasanerrafkhata.core.BaseActivity
import com.asif.hasanerrafkhata.feature.blogPostList.model.BlogPostList
import com.asif.hasanerrafkhata.feature.blogPostList.view.BlogPostListView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.progress
import kotlinx.android.synthetic.main.blogpost_activity.*
import kotlinx.android.synthetic.main.toolbar.*
import java.text.SimpleDateFormat

class BlogPostPostActivity() : BaseActivity() , BlogPostListView {


    private lateinit var presenterPost : BlogPostDetailsPresenter
    override fun layoutId(): Int {
       return R.layout.blogpost_activity
    }




    override val isHomeUpButtonEnable: Boolean
       get() = false

    override fun toolbar(): Toolbar {
        toolbar.title = getString(R.string.toolbar)
        return toolbar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = intent.getIntExtra("value",0)
        presenterPost = BlogPostDetailsPresenterImpl(this)
        presenterPost.singlePost(id)

    }

    override fun progressBarVisibility(isVisible: Boolean) {
        if (isVisible)
            progress.visibility = View.VISIBLE
        else
            progress.visibility = View.GONE

    }

    override fun blogListRetrieveSuccess(blogPostListList: MutableList<BlogPostList>) {
        ////////////////////////        ///////////////////
    }



    @SuppressLint("SimpleDateFormat")
    override fun blogFetchSuccess(blogPostList: BlogPostList) {
        Glide.with(this)
            .load(blogPostList.jetpack_featured_media_url)
            .into(iv_item)
        tv_blog_title.text = Html.fromHtml(blogPostList.title.rendered)
        tv_author_name.text = getString(R.string.writer_name)
        tvDate.text = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(blogPostList.date).toString()
        tv_details.text = Html.fromHtml(blogPostList.content.rendered)
    }

    override fun blogListRetrieveFailure(errorMessage: String) {
        ////////////////////////////             ///////////////////////
    }



}