package com.example.ss_team2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.apollographql.apollo3.api.Optional
import com.example.ss_team2.data.data_source.*
import com.example.ss_team2.data.repository.*
import com.example.ss_team2.presentation.navigation.navGraph.SetupNavGraph
import com.example.ss_team2.type.PostCreateInput
import com.example.ss_team2.ui.theme.SSteam2Theme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val postRepository = PostRepository()
        var postList: MutableList<Post>
        val postCreateInput = PostCreateInput("Ryanke", "find", "學生證", "新齋",Optional.Absent, Optional.Present("新齋回收區"), false, 300, true )
        lifecycleScope.launchWhenCreated {
            postList = postRepository.createPost(postCreateInput)
            Log.d("GraphQL", "Android: $postList")
        }
        setContent {
            SSteam2Theme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

