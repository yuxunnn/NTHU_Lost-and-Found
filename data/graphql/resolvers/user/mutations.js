import UserModel from '../../../models/userModel'
import connectPool from '../../../database'

const userMutations = {
  createUser: async (_, args) => {
    const userId = await UserModel.createUser(connectPool, args.user)
    const user = await UserModel.selectUserById(connectPool, userId)

    return user
  },
  updateCoin: async (_, args) => {
    const userName = await UserModel.updateCoin(connectPool, args.userName, args.changeCoin)
    const user = await UserModel.selectUserByName(connectPool, userName)

    return user
  },
  updateUserHead: async (_, args) => {
    const userName = await UserModel.updateUserHead(connectPool, args.userName, args.userHead)
    const user = await UserModel.selectUserByName(connectPool, userName)

    return user
  }
}

export default userMutations
