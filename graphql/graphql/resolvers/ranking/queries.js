import RankingModel from "../../../models/rankingModel";
import connectPool from '../../../database'

const rankingQueries = {
    ranking: async (_, args) => {
        const ranking = await RankingModel.selectAll(connectPool)

        return ranking
    }
}

export default rankingQueries