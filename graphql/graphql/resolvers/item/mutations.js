import UserItemModel from "../../../models/userItemModel";
import connectPool from '../../../database'

const userItemMutations = {
    updateUserItem: async (_, args) => {
        const userName = await UserItemModel.updateUserItem(connectPool, args)
        const userItem = await UserItemModel.selectUserItem(connectPool, userName)

        return userItem
    },
    createUserItem: async (_, args) => {
        const userName = await UserItemModel.createUserItem(connectPool, args)
        const userItem = await UserItemModel.selectUserItem(connectPool, userName)

        return userItem
    },
    deleteuserItem: async (_, args) => {
        const req = await UserItemModel.deleteuserItem(connectPool, args)

        return req
    }

}

export default userItemMutations