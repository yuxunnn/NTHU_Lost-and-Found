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
//        val rankingRepository = RankingRepository()
//        var rankList: MutableList<Ranking>
//        lifecycleScope.launchWhenCreated {
//            rankList = rankingRepository.getRanking()
//            val rank = rankList[0].school
//            Log.d("GraphQL", "Android: $rank")
//        }
        setContent {
            SSteam2Theme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

