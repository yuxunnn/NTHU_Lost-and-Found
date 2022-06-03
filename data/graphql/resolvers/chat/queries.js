import ChatModel from "../../../models/chatModel";
import connectPool from '../../../database'

const chatQueries = {
    chats: async (_, args) => {
        const chats = await ChatModel.selectAll(connectPool)

        return chats
    },
    chatsByReceive: async (_, args) => {
        const chats = await ChatModel.selectChatsByReceive(connectPool, args.receive)

        return chats
    },
    chatsByReceiveAndSend: async (_, args) => {
        const chats = await ChatModel.selectChatsByReceiveAndSend(connectPool, args.receive, args.send)

        return chats
    }
}

export default chatQueries