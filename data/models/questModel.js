/* eslint-disable no-unused-vars */
export default class QuestModel {
    static async selectAll(conn) {
        try {
            const query = `SELECT * FROM quest`
            const [rows, fields] = await conn.execute(query)

            return rows
        } catch (err) {
            console.error(`[ERROR] QuestModel.selectAll :\n ${err}`)
        }
    }

    static async selectQuest(conn, userName) {
        const _userName = userName

        try {
            const query = `SELECT * FROM quest WHERE userName = '${_userName}'`
            const [rows, fields] = await conn.execute(query)

            return rows[0]
        } catch (err) {
            console.error(`[ERROR] QuestModel.selectAll :\n ${err}`)
        }
    }

    static async createQuest(conn, userName) {
        const _userName = userName

        try {
            const query = `INSERT INTO quest(userName) VALUES('${_userName}')`
            const [rows, fields] = await conn.execute(query)

            return _userName
        } catch (err) {
            console.error(`[ERROR] QuestModel.selectAll :\n ${err}`)
        }
    }

    static async updateQuest(conn, args) {
        const _userName = args.userName
        const _questId = args.questId
        const _updateNum = args.updateNum

        if (_updateNum == 0) throw new Error("UpdateNum is zero.")

        try {
            const query = `UPDATE quest SET ${_questId} = '${_updateNum}' WHERE userName = '${_userName}'`
            const [rows, fields] = await conn.execute(query)

            return _userName
        } catch (err) {
            console.error(`[ERROR] QuestModel.selectAll :\n ${err}`)
        }
    }
}