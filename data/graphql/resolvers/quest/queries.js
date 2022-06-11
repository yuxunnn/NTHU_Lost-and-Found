import QuestModel from "../../../models/questModel";
import connectPool from '../../../database'

const questQueries = {
    quests: async (_, args) => {
        const quests = await QuestModel.selectAll(connectPool)
        var questList = []
        for (const quest of quests) {
            const _quest1Done = quest.quest1Done == 'Y' ? true : false
            const _quest2Done = quest.quest2Done == 'Y' ? true : false
            const _quest3Done = quest.quest3Done == 'Y' ? true : false
            const addQuest = {
                userName: quest.userName,
                quest1: quest.quest1,
                quest2: quest.quest2,
                quest3: quest.quest3,
                quest1Done: _quest1Done,
                quest2Done: _quest2Done,
                quest3Done: _quest3Done
            }
            questList.push(addQuest)
        }
        return questList
    },
    quest: async (_, args) => {
        const quest = await QuestModel.selectQuest(connectPool, args.userName)
        const _quest1Done = quest.quest1Done == 'Y' ? true : false
        const _quest2Done = quest.quest2Done == 'Y' ? true : false
        const _quest3Done = quest.quest3Done == 'Y' ? true : false
        const rtnQuest = {
            userName: quest.userName,
            quest1: quest.quest1,
            quest2: quest.quest2,
            quest3: quest.quest3,
            quest1Done: _quest1Done,
            quest2Done: _quest2Done,
            quest3Done: _quest3Done
        }

        return rtnQuest
    }

}

export default questQueries