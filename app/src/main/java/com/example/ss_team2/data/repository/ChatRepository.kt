package com.example.ss_team2.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.ss_team2.ChatsByReceiveAndSendQuery
import com.example.ss_team2.ChatsByReceiveQuery
import com.example.ss_team2.CreateChatMutation
import com.example.ss_team2.data.data_source.Chat

class ChatRepository {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("http://10.0.2.2:3000/graphql").build()

    //Queries

    suspend fun getChatsByReceive(receive: String): MutableList<Chat> {
        val response = apolloClient.query(ChatsByReceiveQuery(receive)).execute()
        println("MySQL Response = ${response.data?.chatsByReceive}")

        val data = response.data?.chatsByReceive
        var chatsList: MutableList<Chat> = arrayListOf()
        data?.forEach { chat ->
            chatsList.add(
                Chat(
                    chat!!.send,
                    chat!!.receive,
                    chat!!.message,
                    chat!!.createdAt,
                    chat!!.updatedAt
                )
            )
        }

        return chatsList
    }

    suspend fun getChatByBoth(receive: String, send: String): MutableList<Chat> {
        val response = apolloClient.query(ChatsByReceiveAndSendQuery(receive, send)).execute()
        println("MySQL Response = ${response.data?.chatsByReceiveAndSend}")

        val data = response.data?.chatsByReceiveAndSend
        var chatsList: MutableList<Chat> = arrayListOf()

        data?.forEach { chat ->
            chatsList.add(
                Chat(
                    chat!!.send,
                    chat!!.receive,
                    chat!!.message,
                    chat!!.createdAt,
                    chat!!.updatedAt
                )
            )
        }

        return chatsList
    }

    // Mutations
    suspend fun createChat(send: String, receive: String, message: String): MutableList<Chat> {
        val response = apolloClient.mutation(CreateChatMutation(send, receive, message)).execute()
        println("MySQL Response = ${response.data?.createChat}")

        val data = response.data?.createChat
        var chatsList: MutableList<Chat> = arrayListOf()

        data?.forEach { chat ->
            chatsList.add(
                Chat(
                    chat!!.send,
                    chat!!.receive,
                    chat!!.message,
                    chat!!.createdAt,
                    chat!!.updatedAt
                )
            )
        }

        return chatsList
    }
}