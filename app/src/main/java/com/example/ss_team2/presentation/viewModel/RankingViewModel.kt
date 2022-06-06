package com.example.ss_team2.presentation.viewModel

//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.ss_team2.domain.model.SchoolScore
//import com.example.ss_team2.domain.use_case.RankingUseCase
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//
//class RankingViewModel(): ViewModel(){
//    private val rankingUseCase = RankingUseCase()
//
//    //private val _rank = MutableStateFlow(SchoolScore())
//    //val rank : StateFlow<SchoolScore> = _rank
//
//    init{
//
//    }
//
//    //先做累積
//    fun getRanking(){
//        viewModelScope.launch {
//            _rank.value = rankingUseCase.getRanking()
//        }
//    }
//}