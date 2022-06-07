/* eslint-disable no-unused-vars */
export default class HelperModel {
    static async selectPostHelpers(conn, postId) {
        const _postId = postId

        try {
            const query = `SELECT * FROM helper WHERE postId = '${_postId}'`
            const [rows, fields] = await conn.execute(query)

            return rows
        } catch (err) {
            console.error(`[ERROR] HelperModel.selectPostHelpers :\n ${err}`)
        }
    }

    static async createPostHelper(conn, args) {
        const _postId = args.postId
        const _helperName = args.helperName

        try {
            const query = `INSERT INTO helper(postId, helperName) VALUES('${_postId}', '${_helperName}')`
            const [rows, fields] = await conn.execute(query)

            return `Create helper '${_helperName} of post '${_postId}'`
        } catch (err) {
            console.error(`[ERROR] HelperModel.createPostHelper :\n ${err}`)
        }
    }
}