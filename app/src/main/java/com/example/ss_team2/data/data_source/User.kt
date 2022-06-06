package com.example.ss_team2.data.data_source

import com.example.ss_team2.R
import com.example.ss_team2.type.UserCreateInput

data class User(
    val userId: String,
    val userName: String,
    val userSchool: String,
    val userPhoneNumber: String,
    val userEmail: String,
    val userPassword: String,
    val userCoin: Int,
    val userHead: String?,

    val createdAt: Any,
    val updatedAt: Any
)


val emptyUser = User(
    userId = "",
    userName = "",
    userSchool = "",
    userPhoneNumber = "",
    userEmail = "",
    userPassword = "",
    userCoin = 0,
    userHead = "",
    createdAt = 0,
    updatedAt = 0
)

//val userRyan = User(
//    userImage = R.drawable.your_image,
//    username = "ryan_910107",
//    userSchool = "國立交通大學",
//    userPoint = 300,
//    userToolAmount = 88,
//    userPostList = listOf()
//)