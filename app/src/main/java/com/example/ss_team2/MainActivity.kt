package com.example.ss_team2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.ApolloClient
import com.example.ss_team2.UserByIdQuery

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
        val apolloClient = ApolloClient.Builder()
            .serverUrl("http://10.0.2.2:3000/graphql").build()
        lifecycleScope.launchWhenResumed {
            val response = apolloClient.query(UserByIdQuery("1")).execute()
            Log.d("Graphql", "Success: ${response.data}")
        }
    }
}

