package com.example.ss_team2.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.ss_team2.CreatePostHelperMutation
import com.example.ss_team2.PostHelpersQuery
import com.example.ss_team2.data.data_source.Helper

class HelperRepository {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("http://10.0.2.2:3000/graphql").build()

    suspend fun getAllPostHelpers(postId: String): MutableList<Helper>{
        val response = apolloClient.query(PostHelpersQuery(postId)).execute()
        println("MySQL Response = ${response.data?.postHelpers}")

        val data = response.data?.postHelpers
        val helperList: MutableList<Helper> = arrayListOf()

        data?.forEach { helper ->
            helperList.add(Helper(
                helper!!.postId,
                helper!!.helperName
            ))
        }

        return helperList
    }

    suspend fun addPostHelper(postId: String, helperName: String): String{
        val response = apolloClient.mutation(CreatePostHelperMutation(postId, helperName)).execute()
        println("MySQL Response = ${response.data!!.createPostHelper}")

        return response.data!!.createPostHelper
    }
}