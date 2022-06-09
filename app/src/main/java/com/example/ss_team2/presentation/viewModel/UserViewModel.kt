package com.example.ss_team2.presentation.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ss_team2.data.data_source.User
import com.example.ss_team2.data.data_source.UserItem
import com.example.ss_team2.data.data_source.emptyUser
import com.example.ss_team2.data.data_source.emptyUserItem
import com.example.ss_team2.domain.use_case.UserUseCase
import com.example.ss_team2.type.UserCreateInput
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val userUseCase = UserUseCase()

    private val _selectedItem = MutableStateFlow("")
    val selectedItem:StateFlow<String> = _selectedItem

    private val _user = MutableStateFlow(emptyUser)
    val user: StateFlow<User> = _user
    private val _userItem = MutableStateFlow(emptyUserItem)
    val userItem: StateFlow<UserItem> = _userItem
    private val _otherUser = MutableStateFlow(emptyUser)
    val otherUser: StateFlow<User> = _otherUser
    private val _otherUserItem = MutableStateFlow(emptyUserItem)
    val otherUserItem: StateFlow<UserItem> = _otherUserItem

    private val _userCoin = MutableStateFlow(user.value.userCoin)
    val userCoin : StateFlow<Int> = _userCoin

    init {
        viewModelScope.launch {
//            _user.value = userUseCase.getUserByName("huiyuiui")
//            _userItem.value = userUseCase.getUserItem("huiyuiui")
            _otherUser.value = userUseCase.getUserByName("Ryanke")
            _otherUserItem.value = userUseCase.getUserItem("Ryanke")
        }
    }

    fun changeSelectedItem(selectedItem: String){
        viewModelScope.launch {
            _selectedItem.value = selectedItem
        }
    }

    fun getUserById(userId: String) {
        viewModelScope.launch {
            _user.value = userUseCase.getUserById(userId)
        }
    }

    fun getUserByName(userName: String) {
        viewModelScope.launch {
            _user.value = userUseCase.getUserByName(userName)
        }
    }

    fun getOtherUserById(userId: String) {
        viewModelScope.launch {
            _otherUser.value = userUseCase.getUserById(userId)
        }
    }

    fun getOtherUserByName(userName: String) {
        viewModelScope.launch {
            _otherUser.value = userUseCase.getUserByName(userName)
        }
    }

    fun getUserItem(userName: String) {
        viewModelScope.launch {
            _userItem.value = userUseCase.getUserItem(userName)
        }
    }

    fun getOtherUserItem(userName: String) {
        viewModelScope.launch {
            _otherUserItem.value = userUseCase.getUserItem(userName)
        }
    }

    fun createUser(userCreateInput: UserCreateInput) {
        viewModelScope.launch {
            _user.value = userUseCase.createUser(userCreateInput)
            _userItem.value = userUseCase.createUserItem(userCreateInput.userName)
        }
    }

    fun updateCoin(userName: String, changeCoin: Int) {
        viewModelScope.launch {
            _user.value = userUseCase.updateCoin(userName, changeCoin)
            _userCoin.value = user.value.userCoin
        }
    }

    fun updateUserItem(userName: String, itemType: String, changeNum: Int) {
        viewModelScope.launch {
            _userItem.value = userUseCase.updateUserItem(userName, itemType, changeNum)
        }
    }

    fun userLogin (loginInput: String, password: String){
        viewModelScope.launch {
            _user.value = userUseCase.userLogin(loginInput,password)!!
        }
    }
}
