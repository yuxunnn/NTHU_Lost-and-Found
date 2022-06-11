package com.example.ss_team2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.data.data_source.*
import com.example.ss_team2.data.repository.*
import com.example.ss_team2.presentation.navigation.navGraph.SetupNavGraph
import com.example.ss_team2.type.NotiCreateInput
import com.example.ss_team2.ui.theme.SSteam2Theme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userRepository = UserRepository()
        var userQuest: Quest
        lifecycleScope.launchWhenCreated {
            userQuest = userRepository.getUserQuest("huiyuiui")
            Log.d("GraphQL", "Android: $userQuest")
            userQuest = userRepository.getGlobalQuest()
            Log.d("GraphQL", "Android: $userQuest")
            userQuest = userRepository.updateUserQuest("kristen012", "quest2", 1)
            Log.d("GraphQL", "Android: $userQuest")
            userQuest = userRepository.doneUserQuest("kristen012", "quest2")
            Log.d("GraphQL", "Android: $userQuest")
            userQuest = userRepository.createUserQuest("notyuxun")
            Log.d("GraphQL", "Android: $userQuest")
        }
        setContent {
            SSteam2Theme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }

    }
}
