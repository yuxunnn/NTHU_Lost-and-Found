package com.example.ss_team2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ss_team2.presentation.navigation.navGraph.SetupNavGraph
import com.example.ss_team2.ui.theme.SSteam2Theme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SSteam2Theme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

