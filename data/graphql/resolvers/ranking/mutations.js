import RankingModel from "../../../models/rankingModel";
import UserModel from "../../../models/userModel";
import connectPool from '../../../database'

const rankingMutaions = {
    updateRanking: async (_, args) => {
        let nthuScore = 0
        let nctuScore = 0
        let ntuScore = 0
        let nccuScore = 0

        const nthuUsers = await UserModel.selectUsersBySchool(connectPool, "NTHU")
        const nctuUsers = await UserModel.selectUsersBySchool(connectPool, "NCTU")
        const ntuUsers = await UserModel.selectUsersBySchool(connectPool, "NTU")
        const nccuUsers = await UserModel.selectUsersBySchool(connectPool, "NCCU")

        nthuUsers.forEach(user => {
            nthuScore += user.userCoin
        });
        nctuUsers.forEach(user => {
            nctuScore += user.userCoin
        });
        ntuUsers.forEach(user => {
            ntuScore += user.userCoin
        });
        nccuUsers.forEach(user => {
            nccuScore += user.userCoin
        });

        await RankingModel.updateRanking(connectPool, nthuScore, nctuScore, ntuScore, nccuScore)

        const ranking = await RankingModel.selectAll(connectPool)

        return ranking
    }
}

export default rankingMutaions