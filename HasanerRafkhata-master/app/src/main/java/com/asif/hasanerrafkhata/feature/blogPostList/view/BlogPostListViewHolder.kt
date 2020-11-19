package com.asif.hasanerrafkhata.feature.blogPostList.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_blog.view.*

class BlogPostListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val blogItem : ImageView = itemView.iv_blog_item
    val blogTitle : TextView = itemView.tv_post_Title
    val blogDate : TextView = itemView.tv_date
    val blogAuthor : TextView = itemView.tv_author_Name

}
