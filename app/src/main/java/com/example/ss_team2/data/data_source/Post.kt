package com.example.ss_team2.data.data_source

data class Post(
    val postId: String,
    val author: User,
    val postType: String,
    val itemType: String,
    val location: String,
    val postDescribe: String?,
    val hasDone: Boolean,
    val rewardCoin: Int,
    val anonymous: Boolean,

    val createdAt: Any,
    val updatedAt:Any
)

val emptyPost = Post (
    postId = "",
    author = emptyUser,
    postType = "",
    itemType = "",
    location = "",
    postDescribe = "",
    hasDone = false,
    rewardCoin = 0,
    anonymous =  false,

    createdAt = 0,
    updatedAt = 0,
)
