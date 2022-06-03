import ChatModel from "../../../models/chatModel";
import connectPool from '../../../database'

const chatMutations = {
    createChat: async (_, args) => {
        const rtn = await ChatModel.createChat(connectPool, args)

        return rtn
    }
}

export default chatMutations