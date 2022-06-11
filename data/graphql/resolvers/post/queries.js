import PostModel from "../../../models/postModel";
import UserModel from "../../../models/userModel";
import connectPool from '../../../database'

const postQueries = {
    posts: async (_, args) => {
        const posts = await PostModel.selectAll(connectPool)
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
    postById: async (_, args) => {
        const post = await PostModel.selectPostById(connectPool, args.postId)
        const _hasDone = post.hasDone == 'Y' ? true : false
        const _anonymous = post.anonymous == 'Y' ? true : false
        const rtn = {
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

        return rtn
    },
    postSearch: async (_, args) => {
        const posts = await PostModel.searchPost(connectPool, args.postType, args.itemType, args.location)
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
    postByAuthor: async (_, args) => {
        const posts = await PostModel.selectUserPosts(connectPool, args.author)
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
    }
}

export default postQueries