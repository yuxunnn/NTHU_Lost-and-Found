//package com.example.ss_team2.domain.use_case.user
//
//import com.example.ss_team2.domain.model.User
//
//class UserUseCase {
//    private val userRepository = UserRepository()
//
//    suspend fun getUserById(userId: String): User {
//        return userRepository.getUserById(userId)
//    }
//
//    suspend fun getUserByName(userName: String): User {
//        return userRepository.getUserByName(userName)
//    }
//
//    suspend fun getUserItem(userName: String): UserItem {
//        return userRepository.getUserItem(userName)
//    }
//
//    suspend fun createUser(userCreateInput: UserCreateInput): User {
//        return userRepository.createUser(userCreateInput)
//    }
//
//    suspend fun updateCoin(userName: String, changeCoin: Int): Int {
//        return userRepository.updateCoin(userName, changeCoin).userCoin
//    }
//
//    suspend fun createUserItem(userName: String): UserItem {
//        return userRepository.createUserItem(userName)
//    }
//
//    suspend fun updateUserItem(userName: String, itemType: String, changeNum: Int): UserItem {
//        return userRepository.updateUserItem(userName, itemType, changeNum)
//    }
//
//
//}