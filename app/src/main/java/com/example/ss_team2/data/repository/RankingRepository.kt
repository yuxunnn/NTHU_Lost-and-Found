package com.example.ss_team2.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.ss_team2.RankingQuery
import com.example.ss_team2.UpdateRankingMutation
import com.example.ss_team2.data.data_source.Ranking

class RankingRepository {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("http://10.0.2.2:3000/graphql").build()

    suspend fun getRanking(): MutableList<Ranking>{
        val response = apolloClient.query(RankingQuery()).execute()
        println("MySQL Response = ${response.data!!.ranking}")

        val data = response.data!!.ranking
        var rankingList: MutableList<Ranking> = arrayListOf()
        data!!.forEach { rank ->
            rankingList.add(Ranking(
                rank!!.school,
                rank!!.score
            ))
        }

        return rankingList
    }

    suspend fun updateRanking(): MutableList<Ranking>{
        val response = apolloClient.mutation(UpdateRankingMutation()).execute()
        println("MySQL Response = ${response.data!!.updateRanking}")

        val data = response.data!!.updateRanking
        var rankingList: MutableList<Ranking> = arrayListOf()
        data!!.forEach { rank ->
            rankingList.add(Ranking(
                rank!!.school,
                rank!!.score
            ))
        }

        return rankingList
    }
}