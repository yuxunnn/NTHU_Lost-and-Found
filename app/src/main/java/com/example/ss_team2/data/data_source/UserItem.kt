package com.example.ss_team2.data.data_source

data class UserItem(
    val userName: String,
    val waterGun: Int,
    val board: Int,
    val eraser: Int,
    val shit: Int,
    val flag: Int
)

val emptyUserItem = UserItem(
    userName = "",
    waterGun = 0,
    board = 0,
    eraser = 0,
    shit = 0,
    flag = 0
)
