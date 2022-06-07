package com.example.ss_team2.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ss_team2.data.data_source.Chat
import com.example.ss_team2.domain.use_case.ChatUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    private val chatUseCase = ChatUseCase()

    private val _chats = MutableStateFlow(mutableListOf<Chat>())
    val chats: StateFlow<List<Chat>> = _chats
    private val _chat = MutableStateFlow(mutableListOf<Chat>())
    val chat: StateFlow<List<Chat>> = _chat

    init {
        _chats.value = mutableListOf(
            Chat(
                send = "yuxunnn",
                receive = "hiu", message = "cow",
                createdAt = 0, updatedAt = 0
            )
        )
        _chat.value = mutableListOf(
            Chat(
                send = "yuxunnn",
                receive = "yo",
                message = "hello",
                createdAt = 0,
                updatedAt = 0
            ),
            Chat(
                send = "n",
                receive = "yo",
                message = "hello2",
                createdAt = 0,
                updatedAt = 0
            ),
            Chat(
                send = "yuxunnn",
                receive = "yo",
                message = "hello3sssssssssssssssssssssssssssssssssssssssssssssssssssssssss",
                createdAt = 0,
                updatedAt = 0
            )
        )
    }

    fun chatsByReceive(receiver: String) {
        viewModelScope.launch {
            _chats.value = chatUseCase.chatsByReceive(receiver)
        }
    }

    fun chatsByReceiveAndSend(receiver: String, sender: String) {
        viewModelScope.launch {
            _chat.value = chatUseCase.chatsByReceiveAndSend(receiver, sender)
        }
    }

    fun createChat(receiver: String, sender: String, message: String) {
        viewModelScope.launch {
            _chat.value = chatUseCase.createChat(receiver, sender, message)
//            val newChat = _chat.value.toMutableList()
//            newChat.add(
//                Chat(
//                    receive = receiver, send = sender, message = message,
//                    createdAt = 0, updatedAt = 0
//                )
//            )
//            _chat.value = newChat
        }
    }
}