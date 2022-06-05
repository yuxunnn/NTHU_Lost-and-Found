package com.example.ss_team2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.example.ss_team2.UserByIdQuery
import com.example.ss_team2.data.data_source.*
import com.example.ss_team2.data.repository.*
import com.example.ss_team2.domain.use_case.UserUseCase
import com.example.ss_team2.type.MapItemCreateInput
import com.example.ss_team2.type.PostCreateInput
import com.example.ss_team2.type.PostUpdateInput
import com.example.ss_team2.type.UserCreateInput
import java.util.*

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
        val shopItemRepository = ShopItemRepository()
        val chatRepository = ChatRepository()
        val mapItemRepository = MapItemRepository()
        var postList: MutableList<Post>
        var post: Post
        var user: User?
        var quest: Quest
        var userItem: UserItem
        val userCreateInput =
            UserCreateInput("using", "NTHU", "0908388593", "t555555561@gmail.com", "aaaa55555")
        val postCreateInput = PostCreateInput(
            "Ryanke",
            "find",
            "錢包",
            "資電館",
            Optional.Present("放在資電126"),
            false,
            300,
            false
        )
        val postUpdateInput = PostUpdateInput(
            Optional.Absent,
            Optional.Absent,
            Optional.Absent,
            Optional.Present(500),
            Optional.Absent
        )
        var shopItemsList: MutableList<ShopItem>
        var shopItem: ShopItem
        var chatsList: MutableList<Chat>
        var rtn: String
        var mapItemList: MutableList<MapItem>
        val mapItemCreateInput = MapItemCreateInput(
            "flag",
            25.017424480809552,
            121.54099837500733,
            "Ryanke",
            "NTHU"
        )
        lifecycleScope.launchWhenResumed {
//            postList = postRepository.searchPost("lost","學生證", "新齋")
//            Log.d("Granphql", "Response: $postList")

//              post = postRepository.updatePost("14",postUpdateInput )
//              Log.d("graphql", "Response:$post")

//             user = userRepository.getUserById("2")
//             Log.d("graphql", "Response:$user")

//            userItem = userRepository.updateUserItem("Ryanke","waterGun", 10)
//            Log.d("graphql", "Response:$userItem")

//            quest = userRepository.updateUserQuest("notyuxun","quest2", 1)
//            Log.d("graphql", "Android Response:$quest")

//            shopItem = shopItemRepository.getShopItemByType("waterGun")
//            Log.d("graphql", "Android Response:$shopItem")

//            Log.d("graphql", "Android Response:${postRepository.deletePost("17")}")

//              rtn = chatRepository.createChat("huiyuiui","kristen012","記得要做mapItem")

//            chatsList = chatRepository.getChatByBoth("kristen012","huiyuiui")
//            Log.d("graphql", "Android Response:$chatsList")

            mapItemList = mapItemRepository.createMapItem(mapItemCreateInput)
            Log.d("graphql", "Android Response:$mapItemList")
        }
    }
}

