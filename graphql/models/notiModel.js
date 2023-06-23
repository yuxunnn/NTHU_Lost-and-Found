/* eslint-disable no-unused-vars */
export default class NotiModel {
    static async selectByUserName(conn, userName) {
        const _userName = userName

        try {
            const query = `SELECT * FROM noti WHERE receive = '${_userName}'`
            const [rows, fields] = await conn.execute(query)

            return rows
        } catch (err) {
            console.error(`[ERROR] NotiModel.selectByUserName :\n ${err}`)
        }
    }

    static async createNoti(conn, args) {
        const _receive = args.receive
        const _send = args.send
        const _postId = args.postId
        const _notification = args.notification

        try {
            const query = `INSERT INTO noti(receive, send, postId, notification) VALUES('${_receive}', '${_send}', '${_postId}', '${_notification}')`
            const [rows, fields] = await conn.execute(query)
        } catch (err) {
            console.error(`[ERROR] NotiModel.createNoti :\n ${err}`)
        }
    }
}