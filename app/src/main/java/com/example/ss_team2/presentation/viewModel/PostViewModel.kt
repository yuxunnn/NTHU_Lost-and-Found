package com.example.ss_team2.presentation.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ss_team2.data.data_source.Post
import com.example.ss_team2.data.data_source.emptyPost
import com.example.ss_team2.data.data_source.emptyPostList
import com.example.ss_team2.data.data_source.emptyUser
import com.example.ss_team2.domain.use_case.PostUseCase
import com.example.ss_team2.type.PostCreateInput
import com.example.ss_team2.type.PostUpdateInput
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel() : ViewModel() {

    private val postUseCase = PostUseCase()

    private val _myPosts = MutableStateFlow(mutableListOf<Post>())
    private val _posts = MutableStateFlow(emptyPostList)
    private val _post = MutableStateFlow(emptyPost)

    val myPosts: StateFlow<MutableList<Post>> = _myPosts
    val posts: StateFlow<List<Post>> = _posts
    val post: StateFlow<Post> = _post

    init {
        viewModelScope.launch {
            _myPosts.value = postUseCase.getUserPosts("notyuxun")
        }
    }

    fun getPostById(postId: String) {
        viewModelScope.launch {
            _post.value = postUseCase.getPostById(postId)
        }
    }

    fun getMyPosts(myName: String) {
        viewModelScope.launch {
            _myPosts.value = postUseCase.getUserPosts(myName)
        }
    }

    fun getUserPosts(author: String){
        viewModelScope.launch {
            _posts.value = postUseCase.getUserPosts(author)
        }
    }

    fun postSearch(postType: String, itemType: String, location: String) {
        viewModelScope.launch {
            _posts.value = postUseCase.searchPost(postType, itemType, location)
        }
    }

    fun createPost(postCreateInput: PostCreateInput) {
        viewModelScope.launch {
            postUseCase.createPost(postCreateInput)
        }
    }

    //感覺可以先不用
    fun updatePost(postId: String, postUpdateInput: PostUpdateInput) {
        viewModelScope.launch {
            postUseCase.updatePost(postId, postUpdateInput)
        }
    }

    fun deletePost(postId: String) {
        viewModelScope.launch {
            postUseCase.deletePost(postId)
        }
    }
}