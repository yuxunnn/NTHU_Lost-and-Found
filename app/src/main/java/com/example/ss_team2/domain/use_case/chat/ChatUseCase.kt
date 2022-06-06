//package com.example.ss_team2.domain.use_case.chat
//
//class ChatUseCase {
//    private val chatRepository = ChatRepository()
//
//    suspend fun chatsByReceive(receiver: String): List<Chat> {
//        return chatRepository.chatsByReceive(receiver)
//    }
//
//    suspend fun chatsByReceiveAndSend(receiver: String, sender: String): Chat {
//        return chatRepository.chatsByReceiveAndSend(receiver, sender)
//    }
//
//    suspend fun createChat(receiver: String, sender: String, message: String): Chat {
//        return chatRepository.createChat(receiver, sender, message)
//    }
//}