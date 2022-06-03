import QuestModel from "../../../models/questModel";
import connectPool from '../../../database'

const questMutations = {
    createQuest: async (_, args) => {
        const userName = await QuestModel.createQuest(connectPool, args.userName)
        const quest = await QuestModel.selectQuest(connectPool, userName)

        return quest
    },
    updateQuest: async (_, args) => {
        const userName = await QuestModel.updateQuest(connectPool, args)
        const quest = await QuestModel.selectQuest(connectPool, userName)

        return quest
    }

}

export default questMutations