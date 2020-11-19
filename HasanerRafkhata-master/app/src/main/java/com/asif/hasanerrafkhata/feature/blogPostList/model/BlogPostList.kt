package com.asif.hasanerrafkhata.feature.blogPostList.model

import java.io.Serializable

data class BlogPostList(
        val id : Int,
        val title : Title,
        val date : String,
        val jetpack_featured_media_url : String,
        val content: Description


):Serializable{
    data class Title(val rendered : String )
    data class Description (val rendered : String)
}



