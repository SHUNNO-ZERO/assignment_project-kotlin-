package com.asif.hasanerrafkhata.feature.blogPostList.presenter

import com.asif.hasanerrafkhata.feature.blogPostList.model.BlogPostList
import com.asif.hasanerrafkhata.feature.blogPostList.model.BlogPostListCallBack
import com.asif.hasanerrafkhata.feature.blogPostList.model.BlogPostListModel
import com.asif.hasanerrafkhata.feature.blogPostList.model.BlogPostListModelImpl
import com.asif.hasanerrafkhata.feature.blogPostList.view.BlogPostListView

class BlogPostListPresenterImpl(private val viewPost : BlogPostListView): BlogPostListPresenter {
    private val modelPost : BlogPostListModel = BlogPostListModelImpl()

    override fun getBlogPostList() {
        viewPost.progressBarVisibility(true)

        modelPost.getPostList(object : BlogPostListCallBack {
            override fun onSuccess(blogPostListList: MutableList<BlogPostList>) {
                viewPost.progressBarVisibility(false)

                viewPost.blogListRetrieveSuccess(blogPostListList)
            }

            override fun onError(throwable: Throwable) {
               viewPost.progressBarVisibility(false)
                if (throwable.localizedMessage != null)
                    viewPost.blogListRetrieveFailure(throwable.localizedMessage!!)
                else
                    viewPost.blogListRetrieveFailure("something is wrong....")
            }

        })
    }
}