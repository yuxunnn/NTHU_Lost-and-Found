import PostModel from "../../../models/postModel";
import UserModel from "../../../models/userModel";
import connectPool from '../../../database'

const postMutations = {
    createPost: async (_, args) => {
        const _postId = await PostModel.createPost(connectPool, args.post)
        const post = await PostModel.selectPostById(connectPool, _postId)
        const _hasDone = post.hasDone == 'Y' ? true : false
        const _anonymous = post.anonymous == 'Y' ? true : false
        const rtn = {
            postId: post.postId,
            author: UserModel.selectUserByName(connectPool, post.author),
            postType: post.postType,
            itemType: post.itemType,
            location: post.location,
            postDescribe: post.postDescribe,
            hasDone: _hasDone,
            rewardCoin: post.rewardCoin,
            anonymous: _anonymous,
            createdAt: post.createdAt,
            updatedAt: post.updatedAt
        }

        return rtn
    }
}

export default postMutations