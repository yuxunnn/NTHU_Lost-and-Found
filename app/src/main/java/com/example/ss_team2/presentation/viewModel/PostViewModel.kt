package com.example.ss_team2.presentation.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ss_team2.domain.model.Post
import com.example.ss_team2.domain.use_case.PostUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel(): ViewModel(){

    private val postUseCase = PostUseCase()

    private val _posts = MutableStateFlow(postFrog)
    val posts = StateFlow<Post> = _posts,

    init{

    }

     fun createPost(){
         viewModelScope.launch{
             postUseCase.createPost(
                Post(
                    image = ,
                    type = ,
                    what = ,
                    where = ,
                    description = ,
                    done = ,
                    bounty = ,
                    time = ,
                    owner = ,
                )
             )
         }
     }
}