package com.example.ss_team2.profile

import com.example.ss_team2.R

data class Post(val type: Int, val image: Int, val what: List<String>, val where: List<String>)

val tempUserPostData: List<Post> = listOf(
    Post(
        type = 1,
        image = R.drawable.umbrella1,
        what = listOf("雨傘"),
        where = listOf("資電館")
    ),
    Post(
        type = 2,
        image = R.drawable.umbrella2,
        what = listOf("傘"),
        where = listOf("資電館", "小吃部", "碩齋")
    )
)

val tempUserPostData2: List<Post> = listOf(
    Post(
        type = 1,
        image = R.drawable.umbrella1,
        what = listOf("舊雨傘"),
        where = listOf("資電館")
    ),
    Post(
        type = 2,
        image = R.drawable.umbrella2,
        what = listOf("傘"),
        where = listOf("資電館", "小吃部", "碩齋")
    )
)