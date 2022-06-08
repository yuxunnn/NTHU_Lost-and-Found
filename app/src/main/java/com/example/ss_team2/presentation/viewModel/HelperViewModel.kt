package com.example.ss_team2.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ss_team2.data.data_source.Helper
import com.example.ss_team2.domain.use_case.HelperUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HelperViewModel : ViewModel() {

    private val helperUseCase = HelperUseCase()

    private val _helpers = MutableStateFlow(mutableListOf<Helper>())
    val helpers: StateFlow<MutableList<Helper>> = _helpers

    fun getAllPostHelpers(postId: String) {
        viewModelScope.launch {
            _helpers.value = helperUseCase.getAllPostHelpers(postId)
        }
    }

    fun addPostHelper(postId: String, helperName: String) {
        viewModelScope.launch {
            helperUseCase.addPostHelper(postId, helperName)
            _helpers.value = helperUseCase.getAllPostHelpers(postId)
        }
    }

}