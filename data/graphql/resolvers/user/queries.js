import UserModel from '../../../models/userModel'
import connectPool from '../../../database'

const userQueries = {
  users: async (_, args) => {
    const users = await UserModel.selectAll(connectPool)

    return users
  },
  user: async (_, args) => {
    const user = await UserModel.selectUser(connectPool, args.userName)

    return user
  }
}

export default userQueries
