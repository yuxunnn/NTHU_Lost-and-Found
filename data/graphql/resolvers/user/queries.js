import UserModel from '../../../models/userModel'
import connectPool from '../../../database'

const userQueries = {
  users: async (_, args) => {
    const users = await UserModel.selectAll(connectPool)

    return users
  },
  userByName: async (_, args) => {
    const user = await UserModel.selectUserByName(connectPool, args.userName)

    return user
  },
  userById: async (_, args) => {
    const user = await UserModel.selectUserById(connectPool, args.userId)

    return user
  },
  usersBySchool: async (_, args) => {
    const users = await UserModel.selectUsersBySchool(connectPool, args.userSchool)

    return users
  }
}

export default userQueries
