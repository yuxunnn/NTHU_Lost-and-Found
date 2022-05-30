package com.example.ss_team2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ss_team2.firstpage.FirstPage
import com.example.ss_team2.taskList.TaskList
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.whatYouLost.WhatYouLost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //WhatYouLost()
            //TaskList()
            FirstPage()
        }
    }
}