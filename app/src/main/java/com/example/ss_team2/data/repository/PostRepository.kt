package com.example.ss_team2.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.ss_team2.PostByIdQuery
import com.example.ss_team2.PostSearchQuery
import com.example.ss_team2.data.data_source.Post
import com.example.ss_team2.data.data_source.User

class PostRepository {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("http://10.0.2.2:3000/graphql").build()

    suspend fun getPostById(postId: String): Post {
        val response = apolloClient.query(PostByIdQuery(postId = postId)).execute()
        println("Response = ${response.data?.postById}")

        val data = response.data?.postById
        val author = data!!.author
        val user = User(
            author.userId,
            author.userName,
            author.userSchool,
            author.userPhoneNumber,
            author.userEmail,
            "",
            author.userCoin,
            author.userHead,
            author.createdAt,
            author.updatedAt
        )

        return Post(
            data.postId,
            user,
            data.postType,
            data.itemType,
            data.location,
            data.postDescribe,
            data.hasDone,
            data.rewardCoin,
            data.anonymous,
            data.createdAt,
            data.updatedAt
        )
    }

    suspend fun searchPost(
        postType: String,
        itemType: String,
        location: String
    ): MutableList<Post> {
        val response = apolloClient.query(
            PostSearchQuery(
                postType = postType,
                itemType = itemType,
                location = location
            )
        ).execute()
        //println("Response = ${response.data?.postSearch}")

        val data = response.data?.postSearch
        var postList: MutableList<Post> = arrayListOf()

        data?.forEach { post ->
            val author = post?.author
            val user = User(
                author!!.userId,
                author.userName,
                author.userSchool,
                author.userPhoneNumber,
                author.userEmail,
                "",
                author.userCoin,
                author.userHead,
                author.createdAt,
                author.updatedAt
            )

            postList.add(
                Post(
                    post.postId,
                    user,
                    post.postType,
                    post.itemType,
                    post.location,
                    post.postDescribe,
                    post.hasDone,
                    post.rewardCoin,
                    post.anonymous,
                    post.createdAt,
                    post.updatedAt
                )
            )
        }

        return postList
    }

    
}