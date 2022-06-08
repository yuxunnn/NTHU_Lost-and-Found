package com.example.ss_team2.data.data_source

data class UserItem(
    val userName: String,
    val orangeFlag: Int,
    val purpleFlag: Int,
    val yellowFlag: Int,
    val blueFlag: Int,
    val shit: Int,
    val vaccine: Int
)

val emptyUserItem = UserItem(
    userName = "",
    orangeFlag = 0,
    purpleFlag = 0,
    yellowFlag = 0,
    blueFlag = 0,
    shit = 0,
    vaccine = 0
)
