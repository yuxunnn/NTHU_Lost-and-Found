//package com.example.ss_team2.presentation.viewModel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.ss_team2.domain.model.User
//import com.example.ss_team2.domain.model.userFrog
//import com.example.ss_team2.domain.model.userRyan
//import com.example.ss_team2.domain.use_case.user.UserUseCase
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class UserViewModel : ViewModel() {
//
//    private val userUseCase = UserUseCase()
//
////    private val _user = MutableStateFlow(userFrog)
////    val user: StateFlow<User> = _user
////    private val _userItem = MutableStateFlow()
////    val userItem: StateFlow<UserItem> = _userItem
//
//    init {
//
//    }
//
//    fun getUserById(userId: String) {
//        viewModelScope.launch {
//            _user.value = userUseCase.getUserById(userId)
//        }
//    }
//
//    fun getUserByName(userName: String) {
//        viewModelScope.launch {
//            _user.value = userUseCase.getUserByName(userName)
//        }
//    }
//
//    fun getUserItem(userName: String) {
//        viewModelScope.launch {
//            _userItem.value = userUseCase.getUserItem(userName)
//        }
//    }
//
//    fun createUser(userCreateInput: UserCreateInput) {
//        viewModelScope.launch {
//            _user.value = userUseCase.createUser(userCreateInput)
//            _userItem.value = userUseCase.createUserItem(userCreateInput.userName)
//        }
//    }
//
//    fun updateCoin(userName: String, changeCoin: Int) {
//        viewModelScope.launch {
//            _user.value.userCoin = userUseCase.updateCoin(userName, changeCoin)
//        }
//    }
//
//    fun updateUserItem(userName: String, itemType: String, changeNum: Int) {
//        viewModelScope.launch {
//            _userItem.value = userUseCase.updateUserItem(userName, itemType, changeNum)
//        }
//    }
//}