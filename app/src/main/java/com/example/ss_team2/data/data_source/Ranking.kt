package com.example.ss_team2.data.data_source

data class Ranking(
    val school: String,
    val score: Int
)

val emptyRankingList: MutableList<Ranking> = listOf<Ranking>(
    Ranking("清華大學", 500),
    Ranking("交通大學", 300),
    Ranking("台灣大學", 200),
    Ranking("政治大學", 100)
).toMutableList()