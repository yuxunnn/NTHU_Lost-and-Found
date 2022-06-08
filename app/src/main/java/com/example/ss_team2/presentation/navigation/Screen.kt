package com.example.ss_team2.presentation.navigation

const val ROOT_GRAPH_ROUTE = "root"
const val LOST_GRAPH_ROUTE = "lost"
const val FIND_GRAPH_ROUTE = "find"
const val BOTTOM_GRAPH_ROUTE = "bottom"
const val WHAT_ARGUMENT_KEY = "what"
const val WHERE_ARGUMENT_KEY = "where"
const val USERNAME_ARGUMENT_KEY = "username"

sealed class Screen (val route: String) {
    object First: Screen(route = "first_screen")
    object Register: Screen(route = "register_screen")
    object Login: Screen(route = "login_screen")
    object Home: Screen(route = "home_screen")
    object WhatYouLost: Screen(route = "whatyoulost_screen")
    object WhereYouLost: Screen(route = "whereyoulost_screen/{$WHAT_ARGUMENT_KEY}"){
        fun passWhat(
            what: String
        ):String { return "whereyoulost_screen/$what"}
    }
    object WhatYouFind: Screen(route = "whatyoufind_screen")

    object WhereYouFind: Screen(route = "whereyoufind_screen/{$WHAT_ARGUMENT_KEY}"){
        fun passWhat(
            what: String
        ):String { return "whereyoufind_screen/$what"}
    }
    object LostList: Screen(route = "lostlist_screen/{$WHAT_ARGUMENT_KEY}/{$WHERE_ARGUMENT_KEY}"){
        fun passWhatAndWhere(
            what: String,
            where: String
        ): String {
            return "lostlist_screen/$what/$where"
        }
    }
    object FindList: Screen(route = "findlist_screen/{$WHAT_ARGUMENT_KEY}/{$WHERE_ARGUMENT_KEY}"){
        fun passWhatAndWhere(
            what: String,
            where: String
        ): String {
            return "findlist_screen/$what/$where"
        }
    }
    object OthersFindList: Screen(route = "othersfindlist_screen")
    object OthersLostList: Screen(route = "otherslostlist_screen")
    object ChatRoom: Screen(route = "chatroom_screen")
    object ChatList: Screen(route = "chatlist_screen")
    object Map: Screen(route = "map_screen")
    object Shop: Screen(route = "shop_screen")
    object AddFindList: Screen(route = "addfindlist_screen/{$WHAT_ARGUMENT_KEY}/{$WHERE_ARGUMENT_KEY}"){
        fun passWhatAndWhere(
            what: String,
            where: String
        ): String {
            return "addfindlist_screen/$what/$where"
        }
    }
    object AddLostList: Screen(route = "addlostlist_screen/{$WHAT_ARGUMENT_KEY}/{$WHERE_ARGUMENT_KEY}"){
        fun passWhatAndWhere(
            what: String,
            where: String
        ): String {
            return "addlostlist_screen/$what/$where"
        }
    }
    object Confirmation: Screen(route = "confirmation_screen")
    object EditPost: Screen(route = "editpost_screen/{$WHAT_ARGUMENT_KEY}/{$WHERE_ARGUMENT_KEY}/{$USERNAME_ARGUMENT_KEY}"){
        fun passWhatAndWhereAndUserName(
            what: String,
            where: String,
            username: String
        ): String {
            return "editpost_screen/$what/$where/$username"
        }
    }
    object MyPost: Screen(route = "mypost_screen")
    object Profile: Screen(route = "profile_screen")
    object Quest: Screen(route = "quest_screen")
    object Rank: Screen(route = "rank_screen")
    object Notification: Screen(route = "notification_screen")
}
