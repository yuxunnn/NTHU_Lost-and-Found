package com.example.ss_team2.presentation.navigation

const val ROOT_GRAPH_ROUTE = "root"
const val LOST_GRAPH_ROUTE = "lost"
const val FIND_GRAPH_ROUTE = "find"

sealed class Screen (val route: String) {
    object First: Screen(route = "first_screen")
    object Register: Screen(route = "register_screen")
    object Login: Screen(route = "login_screen")
    object Home: Screen(route = "home_screen")
    object WhatYouLost: Screen(route = "whatyoulost_screen")
    object WhereYouLost: Screen(route = "whereyoulost_screen")
    object WhatYouFind: Screen(route = "whatyoufind_screen")
    object WhereYouFind: Screen(route = "whereyoufind_screen")
    object LostList: Screen(route = "lostlist_screen")
    object FindList: Screen(route = "findlist_screen")
    object AddPost: Screen(route = "addpost_screen")
    object OthersFindList: Screen(route = "othersfindlist_screen")
    object OthersLostList: Screen(route = "otherslostlist_screen")
    object ChatRoom: Screen(route = "chatroom_screen")
    object ChatList: Screen(route = "chatlist_screen")
    object Map: Screen(route = "map_screen")
    object Shop: Screen(route = "shop_screen")
    object AddFindList: Screen(route = "addfindlist_screen")
    object AddLostList: Screen(route = "addlostlist_screen")
    object Confirmation: Screen(route = "confirmation_screen")
    object EditPost: Screen(route = "editpost_screen")
}
