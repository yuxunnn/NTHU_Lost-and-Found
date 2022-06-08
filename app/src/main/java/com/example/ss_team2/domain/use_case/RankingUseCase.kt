package com.example.ss_team2.domain.use_case

import com.example.ss_team2.data.data_source.Ranking
import com.example.ss_team2.data.repository.RankingRepository


class RankingUseCase {
    private val rankingRepository =  RankingRepository()

    suspend fun getRanking (): MutableList<Ranking>{
        return rankingRepository.getRanking()
    }

    suspend fun updateRanking(): MutableList<Ranking>{
        return rankingRepository.updateRanking()
    }
}