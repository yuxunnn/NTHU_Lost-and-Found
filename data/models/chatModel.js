/* eslint-disable no-unused-vars */
export default class ChatModel {
    static async selectAll(conn) {
        try {
            const query = `SELECT * FROM chat`
            const [rows, fields] = await conn.execute(query)

            return rows
        } catch (err) {
            console.error(`[ERROR] ChatModel.selectAll :\n ${err}`)
        }
    }
    static async selectChatsByReceive(conn, receive) {
        const _receive = receive

        try {
            const query = `SELECT * FROM chat WHERE receive = '${_receive}'`
            const [rows, fields] = await conn.execute(query)

            return rows
        } catch (err) {
            console.error(`[ERROR] ChatModel.selectChatsByReceive :\n ${err}`)
        }
    }

    static async selectChatsByReceiveAndSend(conn, receive, send) {
        const _receive = receive
        const _send = send

        try {
            const query = `SELECT * FROM chat WHERE receive = '${_receive}' AND send = '${_send}'`
            const [rows, fields] = await conn.execute(query)

            return rows
        } catch (err) {
            console.error(`[ERROR] ChatModel.selectChatsByReceiveAndSend :\n ${err}`)
        }
    }


    static async createChat(conn, args) {
        const _send = args.send
        const _receive = args.receive
        const _message = args.message

        try {
            const query = `INSERT INTO chat(send, receive, message) VALUES('${_send}', '${_receive}', '${_message}')`
            const [rows, fields] = await conn.execute(query)
        } catch (err) {
            console.error(`[ERROR] ChatModel.selectChatsByReceive :\n ${err}`)
        }
    }
}