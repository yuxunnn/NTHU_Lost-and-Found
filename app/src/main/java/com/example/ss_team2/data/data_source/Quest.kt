package com.example.ss_team2.data.data_source

data class Quest(
    val userName: String,
    val quest1: Int,
    val quest2: Int,
    val quest3: Int
)

val emptyQuest = Quest(
    userName = "",
    quest1 = 0,
    quest2 = 0,
    quest3 = 0
)
