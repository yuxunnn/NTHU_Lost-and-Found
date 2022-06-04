package com.example.ss_team2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.ApolloClient
import com.example.ss_team2.UserByIdQuery
import com.example.ss_team2.data.data_source.Post
import com.example.ss_team2.data.data_source.Quest
import com.example.ss_team2.data.data_source.User
import com.example.ss_team2.data.data_source.UserItem
import com.example.ss_team2.data.repository.PostRepository
import com.example.ss_team2.data.repository.UserRepository
import com.example.ss_team2.domain.use_case.UserUseCase
import com.example.ss_team2.type.UserCreateInput

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*SSteam2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }*/
        }
    }

    override fun onResume() {
        super.onResume()
        val postRepository = PostRepository()
        val userRepository = UserRepository()
        var postList: MutableList<Post>
        var post: Post
        var user: User?
        var quest: Quest
        var userItem: UserItem
        val userCreateInput = UserCreateInput("using","NTHU", "0908388593", "t555555561@gmail.com", "aaaa55555")
        lifecycleScope.launchWhenResumed {
//            postList = postRepository.searchPost("lost","學生證", "新齋")
//            Log.d("Granphql", "Response: $postList")

//          post = postRepository.getPostById("3")
//          Log.d("graphql", "Response:$post")

//             user = userRepository.getUserById("2")
//             Log.d("graphql", "Response:$user")

//            userItem = userRepository.updateUserItem("Ryanke","waterGun", 10)
//            Log.d("graphql", "Response:$userItem")

            quest = userRepository.createUserQuest("notyuxun")
            Log.d("graphql", "Android Response:$quest")

//            user = userRepository.createUser(userCreateInput)
//            Log.d("graphql", "Response:$user")


//            user = userRepository.updateUserCoin("huiyuiui", 50)
//            Log.d("graphql", "Response:$user")

        }
    }
}

