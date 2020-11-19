package com.asif.hasanerrafkhata.feature.blogPost.model


import com.asif.hasanerrafkhata.feature.blogPostList.model.BlogPostList

interface BlogPostDetailsCallBack {
    fun onError(throwable: Throwable)
    fun onSuccess(blogPostList: BlogPostList)

}