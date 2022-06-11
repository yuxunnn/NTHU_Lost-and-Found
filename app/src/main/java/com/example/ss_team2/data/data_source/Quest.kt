package com.example.ss_team2.data.data_source

data class Quest(
    val userName: String,
    val quest1: Int,
    val quest2: Int,
    val quest3: Int,
    val quest1Done: Boolean,
    val quest2Done: Boolean,
    val quest3Done: Boolean
)

val emptyQuest = Quest(
    userName = "",
    quest1 = 0,
    quest2 = 0,
    quest3 = 0,
    quest1Done = false,
    quest2Done = false,
    quest3Done = false
)
