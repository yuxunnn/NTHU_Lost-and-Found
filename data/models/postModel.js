/* eslint-disable no-unused-vars */
export default class PostModel {
    static async selectAll(conn) {
        try {
            // Return All Posts
            const query = `SELECT * FROM post`
            const [rows, fields] = await conn.execute(query)

            return rows
        } catch (err) {
            console.error(`[ERROR] PostModel.selectAll :\n ${err}`)
        }
    }

    static async selectPostById(conn, postId) {
        const _postId = postId

        try {
            // Return Post By Id
            const query = `SELECT * FROM post WHERE postId = '${_postId}'`
            const [rows, fields] = await conn.execute(query)

            return rows[0]
        } catch (err) {
            console.error(`[ERROR] PostModel.selectPostById :\n ${err}`)
        }
    }

    static async searchPost(conn, postType, itemType, location) {
        const _postType = postType
        const _itemType = itemType
        const _location = location

        try {
            // Retrun Post List By Keyword
            const query = `SELECT * FROM post WHERE postType = '${_postType}' AND itemType = '${_itemType}' AND location = '${_location}'`
            const [row, fields] = await conn.execute(query)

            return row
        } catch (err) {
            console.error(`[ERROR] PostModel.searchPost :\n ${err}`)
        }
    }

    static async createPost(conn, args) {
        const _author = args.author
        const _postType = args.postType
        const _itemType = args.itemType
        const _location = args.location
        const _postDescribe = args.postDescribe
        const _hasDone = args.hasDone ? 'Y' : 'N'
        const _rewardCoin = args.rewardCoin
        const _anonymous = args.anonymous ? 'Y' : 'N'

        try {
            // Create Post
            const query = `INSERT INTO post (author, postType, itemType, location, postDescribe, hasDone, rewardCoin, anonymous) VALUES ('${_author}', '${_postType}', '${_itemType}', '${_location}', '${_postDescribe}', '${_hasDone}', '${_rewardCoin}', '${_anonymous}')`
            const [rows, fields] = await conn.execute(query)

            return rows.insertId
        } catch (err) {
            console.error(`[ERROR] PostModel.createPost :\n ${err}`)
        }
    }

    static async updatePost(conn, args, modifyPost) {
        let _postId
        let originPost

        if (modifyPost != null) {
            _postId = args.postId
            originPost = await this.selectPostById(conn, _postId)
        } else {
            throw new Error("Post Update is null")
        }

        let _itemType = originPost.itemType
        let _location = originPost.location
        let _postDescribe = originPost.postDescribe
        let _rewardCoin = originPost.rewardCoin
        let _anonymous = originPost.anonymous

        if ('itemType' in modifyPost) _itemType = modifyPost.itemType
        if ('location' in modifyPost) _location = modifyPost.location
        if ('postDescribe' in modifyPost) _postDescribe = modifyPost.postDescribe
        if ('rewardCoin' in modifyPost) _rewardCoin = modifyPost.rewardCoin
        if ('anonymous' in modifyPost) _anonymous = modifyPost.anonymous

        try {
            const query = `UPDATE post SET itemType = '${_itemType}', location = '${_location}', postDescribe = '${_postDescribe}', rewardCoin = '${_rewardCoin}', anonymous = '${_anonymous}' WHERE postId = '${_postId}'`
            const [row, fields] = await conn.execute(query)

            return _postId
        } catch (err) {
            console.error(`[ERROR] PostModel.updatePost :\n ${err}`)
        }
    }

    static async deletePost(conn, postId) {
        const _postId = postId

        try {
            const query = `DELETE FROM post WHERE postId = '${_postId}'`
            const [rows, fields] = await conn.query(query)

            return `Delete user ${_postId} successfull!`
        } catch (err) {
            console.error(`[ERROR] PostModel.deletePost :\n ${err}`)
        }
    }
}