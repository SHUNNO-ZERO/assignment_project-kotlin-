package com.asif.hasanerrafkhata.feature.blogPost.model

import  com.asif.hasanerrafkhata.feature.blogPostList.model.BlogPostList
import  com.asif.hasanerrafkhata.network.BlogApi
import  com.asif.hasanerrafkhata.network.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlogPostDetailsModelImpl : BlogPostDetailsModel {

    private val api: BlogApi = Retrofit.getClient().create(BlogApi::class.java)

    override fun singlePost(post_id: Int, BlogPostDetailModel: BlogPostDetailsCallBack) {

        val call   = api.singlePost(post_id)

        call.enqueue(object : Callback<BlogPostList> {
            override fun onResponse(call: Call<BlogPostList>, response: Response<BlogPostList>) {
                response.body()?.let { BlogPostDetailModel.onSuccess(it) }

            }

            override fun onFailure(call: Call<BlogPostList>, t: Throwable) {
                BlogPostDetailModel.onError(t)
            }

        })
    }
}