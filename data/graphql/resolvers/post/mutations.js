import PostModel from "../../../models/postModel";
import UserModel from "../../../models/userModel";
import connectPool from '../../../database'

const postMutations = {
    createPost: async (_, args) => {
        const _postId = await PostModel.createPost(connectPool, args.post)
        const newPost = await PostModel.selectPostById(connectPool, _postId)
        const _postType = newPost.postType
        const _itemType = newPost.itemType
        const _location = newPost.location
        const posts = await PostModel.searchPost(connectPool, _postType, _itemType, _location)
        var postList = []
        for (const post of posts) {
            const _hasDone = post.hasDone == 'Y' ? true : false
            const _anonymous = post.anonymous == 'Y' ? true : false
            const addPost = {
                postId: post.postId,
                author: UserModel.selectUserByName(connectPool, post.author),
                postType: post.postType,
                itemType: post.itemType,
                location: post.location,
                itemImage: post.itemImage,
                postDescribe: post.postDescribe,
                hasDone: _hasDone,
                rewardCoin: post.rewardCoin,
                anonymous: _anonymous,
                createdAt: post.createdAt,
                updatedAt: post.updatedAt
            }
            postList.push(addPost)
        }

        return postList
    },
    updatePost: async (_, args) => {
        const _postId = await PostModel.updatePost(connectPool, args, args.post)
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
    },
    deletePost: async (_, args) => {
        const rtn = await PostModel.deletePost(connectPool, args.postId)

        return rtn
    },
    donePost: async (_, args) => {
        const postId = await PostModel.donePost(connectPool, args.postId)
        const post = await PostModel.selectPostById(connectPool, postId)

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