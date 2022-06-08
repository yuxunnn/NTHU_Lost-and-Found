package com.example.ss_team2.domain.use_case

import com.example.ss_team2.data.data_source.Chat
import com.example.ss_team2.data.repository.ChatRepository

class ChatUseCase {
    private val chatRepository = ChatRepository()

    suspend fun chatsByReceive(receiver: String): MutableList<Chat> {
        return chatRepository.getChatsByReceive(receiver)
    }

    suspend fun chatsByReceiveAndSend(receiver: String, sender: String): MutableList<Chat> {
        return chatRepository.getChatByBoth(receiver, sender)
    }

    suspend fun createChat(receiver: String, sender: String, message: String): MutableList<Chat> {
//        return chatRepository.createChat(receiver, sender, message)
        return chatRepository.getChatByBoth(receiver, sender)
    }
}