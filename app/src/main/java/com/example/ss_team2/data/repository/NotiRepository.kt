package com.example.ss_team2.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.ss_team2.CreateNotiMutation
import com.example.ss_team2.NotiByNameQuery
import com.example.ss_team2.data.data_source.Noti
import com.example.ss_team2.type.NotiCreateInput

class NotiRepository {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("http://10.0.2.2:3000/graphql").build()

    suspend fun getNotisByName(receive: String): MutableList<Noti>{
        val response = apolloClient.query(NotiByNameQuery(receive)).execute()
        println("MySQL Response = ${response.data?.notiByName}")

        val data = response.data?.notiByName
        var notiList: MutableList<Noti> = arrayListOf()

        data?.forEach { noti ->
            notiList.add(Noti(
                noti!!.receive,
                noti!!.send,
                noti!!.postId,
                noti!!.notification,
                noti!!.createdAt,
                noti!!.updatedAt
            ))
        }

        return notiList
    }

    suspend fun  createNoti(newNoti: NotiCreateInput): MutableList<Noti>{
        val response = apolloClient.mutation(CreateNotiMutation(newNoti)).execute()
        println("MySQL Response = ${response.data?.createNoti}")

        val data = response.data?.createNoti
        var notiList: MutableList<Noti> = arrayListOf()

        data?.forEach { noti ->
            notiList.add(Noti(
                noti!!.receive,
                noti!!.send,
                noti!!.postId,
                noti!!.notification,
                noti!!.createdAt,
                noti!!.updatedAt
            ))
        }

        return notiList
    }
}