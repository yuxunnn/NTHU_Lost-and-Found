package com.example.ss_team2.presentation.viewModel


//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.ss_team2.domain.model.Post
//import com.example.ss_team2.domain.model.tempUserPostData
//import com.example.ss_team2.domain.use_case.PostUseCase
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class PostViewModel(): ViewModel(){
//
//    private val postUseCase = PostUseCase()
//
//    //private val _posts = MutableStateFlow(List<Post>)
//    //private val _post = MutableStateFlow(PostFrog)
//
//    //val posts: StateFlow< List<Post> > = _posts
//    //val post : StateFlow<Post> = _post
//
//    init{
//
//    }
//
//    fun getPostById (postId: String){
//        viewModelScope.launch {
//            _post.value = postUseCase.getPostById(postId)
//        }
//    }
//
//    fun postSearch(postType: String, itemType :String, location:String){
//        viewModelScope.launch {
//            _posts.value = postUseCase.postSearch(postType, itemType, location)
//        }
//    }
//
//    fun createPost(postcreateInput: PostCreateInput){
//        viewModelScope.launch{
//            postUseCase.createPost(postcreateInput)
//        }
//    }
//
//    //感覺可以先不用
//    fun updatePost(postId: String, postUpdateInput: postUpdateInput){
//        viewModelScope.launch{
//            postUseCase.updatePost(postId, postUpdateInput)
//        }
//    }
//
//    fun deletePost(postId: String){
//        viewModelScope.launch {
//            postUseCase.deletePost(postId)
//        }
//    }
//}