package com.example.ss_team2.domain.model

import com.example.ss_team2.R
import com.example.ss_team2.data.data_source.User
import com.example.ss_team2.data.data_source.emptyUser
import java.time.LocalDateTime

data class Post(
    // 圖片
    val image: Int,
    // 遺失 or 撿到
    val type: Int,
    // 物品種類
    val what: String,
    // 地點
    val where: List<String>,
    // 物品描述
    val description: String,
    // 是否取回
    val done: Boolean,
    // 懸賞
    val bounty: Int,
    // 時間
    val time: LocalDateTime,
    // 作者
    val owner: User
)

val tempUserPostData: List<Post> = listOf(
    Post(
        image = R.drawable.umbrella1,
        type = 0,
        what = "雨傘",
        where = listOf("資電館"),
        description = "",
        done = false,
        bounty = 20,
        time = LocalDateTime.of(2022, 6, 1, 12, 20),
        owner = emptyUser
    ),
    Post(
        type = 1,
        image = R.drawable.umbrella2,
        what = "傘",
        where = listOf("資電館", "小吃部", "碩齋"),
        description = "",
        done = true,
        bounty = 20,
        time = LocalDateTime.of(2022, 6, 1, 12, 20),
        owner = emptyUser
    )
)

val tempUserPostData2: List<Post> = listOf(
    Post(
        type = 0,
        image = R.drawable.umbrella1,
        what = "雨傘",
        where = listOf("資電館"),
        description = "",
        done = false,
        bounty = 20,
        time = LocalDateTime.of(2022, 6, 1, 12, 20),
        owner = emptyUser
    ),
    Post(
        type = 1,
        image = R.drawable.umbrella2,
        what = "傘",
        where = listOf("資電館", "小吃部"),
        description = "",
        done = true,
        bounty = 20,
        time = LocalDateTime.of(2022, 6, 1, 12, 20),
        owner = emptyUser
    )
)