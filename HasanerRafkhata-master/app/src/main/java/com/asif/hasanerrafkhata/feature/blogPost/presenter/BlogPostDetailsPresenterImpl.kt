package com.asif.hasanerrafkhata.feature.blogPost.presenter

import com.asif.hasanerrafkhata.feature.blogPostList.model.BlogPostList
import com.asif.hasanerrafkhata.feature.blogPost.model.BlogPostDetailsCallBack
import com.asif.hasanerrafkhata.feature.blogPost.model.BlogPostDetailsModel
import com.asif.hasanerrafkhata.feature.blogPost.model.BlogPostDetailsModelImpl
import com.asif.hasanerrafkhata.feature.blogPostList.view.BlogPostListView

class BlogPostDetailsPresenterImpl(private val viewPost: BlogPostListView): BlogPostDetailsPresenter {
    private val modelPost : BlogPostDetailsModel = BlogPostDetailsModelImpl()

    override fun singlePost(postId: Int) {
        viewPost.progressBarVisibility(true)

       modelPost.singlePost(postId, object : BlogPostDetailsCallBack {
           override fun onSuccess(blogPostList: BlogPostList) {
               viewPost.progressBarVisibility(false)
               viewPost.blogFetchSuccess(blogPostList)
           }

           override fun onError(throwable: Throwable) {
               viewPost.progressBarVisibility(false)
               if (throwable.localizedMessage != null)
                   viewPost.blogListRetrieveFailure(throwable.localizedMessage!!)
               else
                   viewPost.blogListRetrieveFailure("something is wrong...")

           }
       })

    }


}