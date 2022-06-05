package com.example.ss_team2.domain.use_case

//import android.location.Location
//import com.example.ss_team2.domain.model.Post
//
//class PostUseCase {
//    private val postRepository: PostRepository()
//
//
//    suspend fun getPostById(postId: String): Post{
//        return postRepository.getPostById(postId)
//    }
//
//    suspend fun postSearch(postType: String, ItemType :String, Location:String): List<Post>? {
//        return postRepository.postSearch(postType, ItemType, Location)
//    }
//
//    //應該不用return東西吧?
//    suspend fun createPost(postcreateInput: PostCreateInput) {
//        postRepository.createPost(postcreateInput)
//    }
//
//    suspend fun updatePost(postId: String, postUpdateInput: postUpdateInput){
//        postRepository.updatePost(postId, postUpdateInput)
//    }
//
//    suspend fun deletePost(postId: String){
//        postRepository.deletePost(postId)
//    }
//}