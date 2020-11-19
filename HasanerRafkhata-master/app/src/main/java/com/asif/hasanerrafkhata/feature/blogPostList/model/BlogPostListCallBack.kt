package com.asif.hasanerrafkhata.feature.blogPostList.model

interface BlogPostListCallBack {
    fun onSuccess(blogPostListList: MutableList<BlogPostList>)
    fun onError(throwable: Throwable)
}