package com.example.ss_team2.domain.use_case

import com.example.ss_team2.data.data_source.Quest
import com.example.ss_team2.data.data_source.User
import com.example.ss_team2.data.data_source.UserItem
import com.example.ss_team2.data.repository.UserRepository
import com.example.ss_team2.type.UserCreateInput

class UserUseCase {
    private val userRepository = UserRepository()

    suspend fun getUserById(userId: String): User {
        return userRepository.getUserById(userId)
    }

    suspend fun getUserByName(userName: String): User {
        return userRepository.getUserByName(userName)
    }

    suspend fun getUserItem(userName: String): UserItem {
        return userRepository.getUserItem(userName)
    }

    suspend fun createUser(userCreateInput: UserCreateInput): User {
        return userRepository.createUser(userCreateInput)
    }

    suspend fun updateCoin(userName: String, changeCoin: Int): User {
        return userRepository.updateUserCoin(userName, changeCoin)
    }

    suspend fun createUserItem(userName: String): UserItem {
        return userRepository.createUserItem(userName)
    }

    suspend fun updateUserItem(userName: String, itemType: String, changeNum: Int): UserItem {
        return userRepository.updateUserItem(userName, itemType, changeNum)
    }

    suspend fun updateUserHead(userName: String, userHead: String): User{
        return userRepository.updateUserHead(userName, userHead)
    }

    suspend fun userLogin(loginInput: String, password: String): User?{
        return userRepository.userLogin(loginInput, password)
    }

    suspend fun createUserQuest(userName: String): Quest{
        return userRepository.createUserQuest(userName)
    }

    suspend fun updateUserQuest(userName: String, questId: String, updateNum: Int): Quest{
        return userRepository.updateUserQuest(userName,questId,updateNum)
    }

    suspend fun getUserQuest(userName: String):Quest{
        return userRepository.getUserQuest(userName)
    }

    suspend fun doneUserQuest(userName: String, questId: String):Quest{
        return userRepository.doneUserQuest(userName, questId)
    }
}