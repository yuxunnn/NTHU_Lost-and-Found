package com.example.ss_team2.domain.model

import com.example.ss_team2.R

data class User(
    val userImage: Int,
    val username: String,
    val userSchool: String,
    val userPoint: Int,
    val userToolAmount: Int,
    val userPostList: List<Post>
)

val userFrog = User(
    userImage = R.drawable.my_image,
    username = "frog_0219",
    userSchool = "國立台灣大學",
    userPoint = 520,
    userToolAmount = 9,
    userPostList = tempUserPostData
)

val userRyan = User(
    userImage = R.drawable.your_image,
    username = "ryan_910107",
    userSchool = "國立交通大學",
    userPoint = 300,
    userToolAmount = 88,
    userPostList = tempUserPostData2
)