package com.example.ss_team2.domain.use_case

import com.example.ss_team2.data.data_source.Helper
import com.example.ss_team2.data.repository.HelperRepository

class HelperUseCase {
    private val helperRepository = HelperRepository()

    suspend fun getAllPostHelpers(postId: String): MutableList<Helper>{
        return helperRepository.getAllPostHelpers(postId)
    }

    suspend fun addPostHelper(postId: String, helperName: String): String{
        return helperRepository.addPostHelper(postId, helperName)
    }
}