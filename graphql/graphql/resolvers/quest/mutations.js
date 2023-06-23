import QuestModel from "../../../models/questModel";
import connectPool from '../../../database'

const questMutations = {
    createQuest: async (_, args) => {
        const userName = await QuestModel.createQuest(connectPool, args.userName)
        const quest = await QuestModel.selectQuest(connectPool, userName)

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
    },
    updateQuest: async (_, args) => {
        const userName = await QuestModel.updateQuest(connectPool, args)
        const quest = await QuestModel.selectQuest(connectPool, userName)

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
    },
    doneQuest: async (_, args) => {
        const userName = await QuestModel.doneQuest(connectPool, args.userName, args.questId)
        const quest = await QuestModel.selectQuest(connectPool, userName)

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

export default questMutations