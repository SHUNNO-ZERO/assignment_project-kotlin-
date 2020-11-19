package com.asif.hasanerrafkhata.feature.blogPostList.model

import com.asif.hasanerrafkhata.network.BlogApi
import com.asif.hasanerrafkhata.network.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BlogPostListModelImpl : BlogPostListModel {

private val api: BlogApi = Retrofit.getClient().create(BlogApi::class.java)
    private val call : Call<MutableList<BlogPostList>> = api.getList()
    
    override fun getPostList(blogPostListCallBack: BlogPostListCallBack) {

        call.enqueue(object : Callback<MutableList<BlogPostList>> {
            override fun onResponse(
                call: Call<MutableList<BlogPostList>>,
                response: Response<MutableList<BlogPostList>>)
            {
                response.body()?.let { blogPostListCallBack.onSuccess(it) }
            }

            override fun onFailure(call: Call<MutableList<BlogPostList>>, t: Throwable) {
                blogPostListCallBack.onError(t)
            }

        })
    }
}