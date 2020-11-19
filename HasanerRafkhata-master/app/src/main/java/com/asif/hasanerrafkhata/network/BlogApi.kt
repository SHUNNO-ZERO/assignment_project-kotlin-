package com.asif.hasanerrafkhata.network

import com.asif.hasanerrafkhata.feature.blogPostList.model.BlogPostList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface BlogApi {

    @GET ("posts")
    fun getList() : Call<MutableList<BlogPostList>>

    @GET("posts/{post_id}")
    fun singlePost(@Path("post_id") post_id : Int): Call<BlogPostList>
}