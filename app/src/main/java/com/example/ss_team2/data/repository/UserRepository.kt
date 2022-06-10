package com.example.ss_team2.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.ss_team2.*
import com.example.ss_team2.data.data_source.Quest
import com.example.ss_team2.data.data_source.User
import com.example.ss_team2.data.data_source.UserItem
import com.example.ss_team2.type.UserCreateInput

class UserRepository {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("http://10.0.2.2:3000/graphql").build()

// Queries

    suspend fun getUserById(userId: String): User {
        val response = apolloClient.query(UserByIdQuery(userId = userId)).execute()
        //println("Response = ${response.data?.userById}")

//        if(response.data == null) return null

        val user = response.data?.userById

        return User(
            user!!.userId,
            user.userName,
            user.userSchool,
            user.userPhoneNumber,
            user.userEmail,
            "",
            user.userCoin,
            user.userHead,
            user.createdAt,
            user.updatedAt
        )
    }

    suspend fun getUserByName(userName: String): User{
        val response = apolloClient.query(UserByNameQuery(userName = userName)).execute()
        //println("Response = ${response.data?.userByName}")

        val user = response.data?.userByName

        return User(
            user!!.userId,
            user.userName,
            user.userSchool,
            user.userPhoneNumber,
            user.userEmail,
            "",
            user.userCoin,
            user.userHead,
            user.createdAt,
            user.updatedAt
        )
    }

    suspend fun getUserItem(userName: String): UserItem{
        val response = apolloClient.query(UserItemQuery(userName = userName)).execute()
        println("MySQL Response = ${response.data?.userItem}")

        val userItem = response.data?.userItem

        return UserItem(
            userItem!!.userName,
            userItem.orangeFlag,
            userItem.purpleFlag,
            userItem.yellowFlag,
            userItem.blueFlag,
            userItem.shit,
            userItem.vaccine
        )
    }

    suspend fun userLogin(loginInput: String, password: String): User?{
        val response = apolloClient.query(UserLoginQuery(loginInput, password)).execute()
        println("MySQL Response = ${response.data?.userLogin}")

        val user = response.data?.userLogin
        if(user == null) return null

        return User(
            user.userId,
            user.userName,
            user.userSchool,
            user.userPhoneNumber,
            user.userEmail,
            user.userPassword,
            user.userCoin,
            user.userHead,
            user.createdAt,
            user.updatedAt
        )
    }

    suspend fun getUserQuest(userName: String): Quest {
        val response = apolloClient.query(QuestQuery(userName)).execute()
        println("MySQL Response = ${response.data?.quest}")

        val userQuest = response.data?.quest

        return Quest(
            userQuest!!.userName,
            userQuest.quest1,
            userQuest.quest2,
            userQuest.quest3
        )
    }

    suspend fun getGlobalQuest(): Quest {
        val response = apolloClient.query(QuestQuery("Global")).execute()
        println("MySQL Response = ${response.data?.quest}")

        val globalQuest = response.data?.quest

        return Quest(
            globalQuest!!.userName,
            globalQuest.quest1,
            globalQuest.quest2,
            globalQuest.quest3
        )
    }

// Mutations

    suspend fun createUser(newUser: UserCreateInput): User{
        val response = apolloClient.mutation(CreateUserMutation(newUser)).execute()
        println("MySQL Response = ${response.data?.createUser}")

        val user = response.data?.createUser

        return User(
            user!!.userId,
            user.userName,
            user.userSchool,
            user.userPhoneNumber,
            user.userEmail,
            "",
            user.userCoin,
            user.userHead,
            user.createdAt,
            user.updatedAt
        )
    }

    suspend fun updateUserCoin(userName: String, changeCoin: Int): User{
        val response = apolloClient.mutation(UpdateCoinMutation(userName,changeCoin)).execute()
        println("MySQL Response = ${response.data!!.updateCoin}")

        val user = response.data!!.updateCoin

        return User(
            user!!.userId,
            user.userName,
            user.userSchool,
            user.userPhoneNumber,
            user.userEmail,
            "",
            user.userCoin,
            user.userHead,
            user.createdAt,
            user.updatedAt
        )
    }

    suspend fun createUserItem(userName: String): UserItem{
        val response = apolloClient.mutation(CreateUserItemMutation(userName = userName)).execute()
        println("MySQL Response = ${response.data!!.createUserItem}")

        val userItem = response.data!!.createUserItem

        return UserItem(
            userItem!!.userName,
            userItem.orangeFlag,
            userItem.purpleFlag,
            userItem.yellowFlag,
            userItem.blueFlag,
            userItem.shit,
            userItem.vaccine
        )
    }

    suspend fun updateUserItem(userName: String, itemType: String, changeNum: Int): UserItem{
        val response = apolloClient.mutation(UpdateUserItemMutation(userName,itemType,changeNum)).execute()
        println("MySQL Response = ${response.data!!.updateUserItem}")

        val userItem = response.data!!.updateUserItem

        return UserItem(
            userItem!!.userName,
            userItem.orangeFlag,
            userItem.purpleFlag,
            userItem.yellowFlag,
            userItem.blueFlag,
            userItem.shit,
            userItem.vaccine
        )
    }

    suspend fun createUserQuest(userName: String): Quest{
        val response = apolloClient.mutation(CreateQuestMutation(userName = userName)).execute()
        println("MySQL Response = ${response.data!!.createQuest}")

        val userQuest = response.data!!.createQuest

        return Quest(
            userQuest.userName,
            userQuest.quest1,
            userQuest.quest2,
            userQuest.quest3
        )
    }

    suspend fun  updateUserQuest(userName: String, questId: String, updateNum: Int): Quest{
        val response = apolloClient.mutation(UpdateQuestMutation(userName,questId,updateNum)).execute()
        println("MySQL Response = ${response.data!!.updateQuest}")

        val userQuest = response.data!!.updateQuest

        return Quest(
            userQuest.userName,
            userQuest.quest1,
            userQuest.quest2,
            userQuest.quest3
        )
    }

    suspend fun updateUserHead(userName: String, userHead: String): User{
        val response = apolloClient.mutation(UpdateUserHeadMutation(userName, userHead)).execute()
        println("MySQL Response = ${response.data!!.updateUserHead}")

        val user = response.data!!.updateUserHead

        return User(
            user!!.userId,
            user.userName,
            user.userSchool,
            user.userPhoneNumber,
            user.userEmail,
            "",
            user.userCoin,
            user.userHead,
            user.createdAt,
            user.updatedAt
        )

    }
}