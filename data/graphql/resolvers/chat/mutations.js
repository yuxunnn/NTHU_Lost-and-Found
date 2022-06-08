import ChatModel from "../../../models/chatModel";
import connectPool from '../../../database'

const chatMutations = {
    createChat: async (_, args) => {
        await ChatModel.createChat(connectPool, args)
        const chats = await ChatModel.selectChatsByReceiveAndSend(connectPool, args.receive, args.send)

        return chats
    }
}

export default chatMutations