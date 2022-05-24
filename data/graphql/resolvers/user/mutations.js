import UserModel from '../../../models/userModel'
import connectPool from '../../../database'

const userMutations = {
  createUser: async (_, args) => {
    const userId = await UserModel.createUser(connectPool, args.user)
    const user = await UserModel.selectUserById(connectPool, userId)

    return user
  }
}

export default userMutations
