package com.example.ss_team2.data.data_source

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