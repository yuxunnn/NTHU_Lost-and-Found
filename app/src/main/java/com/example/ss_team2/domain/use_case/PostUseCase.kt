package com.example.ss_team2.domain.use_case

import com.example.ss_team2.data.data_source.Post
import com.example.ss_team2.data.repository.PostRepository
import com.example.ss_team2.type.PostCreateInput
import com.example.ss_team2.type.PostUpdateInput

class PostUseCase {
    private val postRepository = PostRepository()


    suspend fun getPostById(postId: String): Post{
        return postRepository.getPostById(postId)
    }

    suspend fun getUserPosts(author: String): MutableList<Post>{
        return postRepository.getUserPosts(author)
    }

    suspend fun searchPost(postType: String, ItemType :String, Location:String): MutableList<Post> {
        return postRepository.searchPost(postType, ItemType, Location)
    }

    suspend fun createPost(postCreateInput: PostCreateInput): MutableList<Post>{
        return postRepository.createPost(postCreateInput)
    }

    suspend fun updatePost(postId: String, postUpdateInput: PostUpdateInput){
        postRepository.updatePost(postId, postUpdateInput)
    }

    suspend fun deletePost(postId: String){
        postRepository.deletePost(postId)
    }
}