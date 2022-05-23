/* eslint-disable no-unused-vars */
export default class UserModel {
  static async selectAll (conn) {
    try {
      // Return all users
      const query = 'SELECT * FROM user'
      const [rows, fields] = await conn.execute(query)

      return rows
    } catch (err) {
      console.error(`[ERROR] userModel.selectAll :\n ${err}`)
    }
  }

  static async selectUser (conn, userName) {
    const _userName = userName

    try {
      const query = `SELECT * FROM user WHERE userName = '${_userName}'`
      const [rows, fields] = await conn.execute(query)

      return rows[0]
    } catch (err) {
      console.error(`[ERROR] userModel.selectUser :\n ${err}`)
    }
  }
}
