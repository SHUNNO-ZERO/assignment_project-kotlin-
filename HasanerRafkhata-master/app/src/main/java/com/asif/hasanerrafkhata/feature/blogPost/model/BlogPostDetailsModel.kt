package com.asif.hasanerrafkhata.feature.blogPost.model

interface BlogPostDetailsModel {
    fun singlePost(post_id: Int, BlogPostDetailModel: BlogPostDetailsCallBack)
}