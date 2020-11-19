package com.asif.hasanerrafkhata.feature.blogPostList.view

import com.asif.hasanerrafkhata.feature.blogPostList.model.BlogPostList

interface BlogPostListView {
    fun progressBarVisibility(isVisible: Boolean)
    fun blogListRetrieveSuccess(blogPostListList: MutableList<BlogPostList>)
    fun blogFetchSuccess(blogPostList: BlogPostList)
    fun blogListRetrieveFailure(errorMessage: String)
}