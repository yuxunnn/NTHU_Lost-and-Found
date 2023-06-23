import UserItemModel from "../../../models/userItemModel";
import connectPool from '../../../database'

const userItemQueries = {
    userItems: async (_, args) => {
        const userItems = await UserItemModel.selectAll(connectPool)

        return userItems
    },
    userItem: async (_, args) => {
        const userItem = await UserItemModel.selectUserItem(connectPool, args.userName)

        return userItem
    }
}

export default userItemQueries