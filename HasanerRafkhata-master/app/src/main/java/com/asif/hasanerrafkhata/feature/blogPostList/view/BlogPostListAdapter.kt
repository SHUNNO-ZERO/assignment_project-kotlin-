package com.asif.hasanerrafkhata.feature.blogPostList.view

import android.annotation.SuppressLint
import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.asif.hasanerrafkhata.R
import com.asif.hasanerrafkhata.core.ItemClickListener
import com.asif.hasanerrafkhata.feature.blogPostList.model.BlogPostList
import java.text.SimpleDateFormat


class BlogPostListAdapter(private val blogPostListList: MutableList<BlogPostList>, private val itemClickListener: ItemClickListener):RecyclerView.Adapter<BlogPostListViewHolder>() {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogPostListViewHolder {
        context= parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_blog, parent, false)
        return BlogPostListViewHolder(view)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holderPostList: BlogPostListViewHolder, position: Int) {
        val blog = blogPostListList[position]
        Glide.with(holderPostList.blogItem)
                .load(blog.jetpack_featured_media_url)
                .into(holderPostList.blogItem)
        holderPostList.blogTitle.text = Html.fromHtml(blog.title.rendered)

        holderPostList.blogDate.text = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(blog.date).toString()
        holderPostList.blogAuthor.text = holderPostList.itemView.context.getString(R.string.writer_name)

        holderPostList.itemView.setOnClickListener { itemClickListener.itemClick(position) }
    }

    override fun getItemCount(): Int {
        return blogPostListList.size
    }
}