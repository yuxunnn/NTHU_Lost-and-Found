import QuestModel from "../../../models/questModel";
import connectPool from '../../../database'

const questQueries = {
    quests: async (_, args) => {
        const quests = await QuestModel.selectAll(connectPool)

        return quests
    },
    quest: async (_, args) => {
        const quest = await QuestModel.selectQuest(connectPool, args.userName)

        return quest
    }

}

export default questQueries