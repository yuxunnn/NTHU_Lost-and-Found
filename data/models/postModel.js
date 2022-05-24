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

            return row[0]
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
}