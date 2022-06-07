package com.example.ss_team2.data.data_source

data class Chat(
    val send: String,
    val receive: String,
    val message: String,

    val createdAt: Any,
    val updatedAt: Any
)

val emptyChat = Chat(
    send = "",
    receive = "",
    message = "",
    createdAt = 0,
    updatedAt = 0
)
