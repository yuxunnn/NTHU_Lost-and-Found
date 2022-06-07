/* eslint-disable no-unused-vars */
export default class UserModel {
  static async selectAll(conn) {
    try {
      // Return all users
      const query = 'SELECT * FROM user'
      const [rows, fields] = await conn.execute(query)

      return rows
    } catch (err) {
      console.error(`[ERROR] userModel.selectAll :\n ${err}`)
    }
  }

  static async selectUserById(conn, userId) {
    const _userId = userId

    try {
      // Return User
      const query = `SELECT * FROM user WHERE userId = '${_userId}'`
      const [rows, fields] = await conn.execute(query)

      return rows[0]
    } catch (err) {
      console.error(`[ERROR] userModel.selectUserById :\n ${err}`)
    }
  }

  static async selectUserByName(conn, userName) {
    const _userName = userName

    try {
      // Return User
      const query = `SELECT * FROM user WHERE userName = '${_userName}'`
      const [rows, fields] = await conn.execute(query)

      return rows[0]
    } catch (err) {
      console.error(`[ERROR] userModel.selectUserByName :\n ${err}`)
    }
  }

  static async selectUsersBySchool(conn, userSchool) {
    const _userSchool = userSchool

    try {
      const query = `SELECT * FROM user WHERE userSchool = '${_userSchool}'`
      const [rows, fields] = await conn.execute(query)

      return rows
    } catch (err) {
      console.error(`[ERROR] userModel.selectUsersBySchool :\n ${err}`)
    }
  }

  static async userLogin(conn, loginInput, password) {
    const _loginInput = loginInput
    const _password = password

    try {
      const query = `SELECT * FROM user WHERE userEmail = '${_loginInput}' OR userPhoneNumber = '${_loginInput}'`
      const [rows, fields] = await conn.execute(query)
      console.log(rows[0])

      if (_password == rows[0].userPassword) return rows[0]
      else return null
    } catch (err) {
      console.error(`[ERROR] userModel.userLogin :\n ${err}`)
    }
  }

  static async createUser(conn, args) {
    const _userName = args.userName
    const _userSchool = args.userSchool
    const _userPhoneNumber = args.userPhoneNumber
    const _userEmail = args.userEmail
    const _userPassword = args.userPassword

    try {
      // Return insert userId
      const query = `INSERT INTO user (userName, userSchool, userPhoneNumber, userEmail, userPassword) VALUES ('${_userName}', '${_userSchool}', '${_userPhoneNumber}', '${_userEmail}', '${_userPassword}')`
      const [rows, fields] = await conn.execute(query)

      return rows.insertId
    } catch (err) {
      console.error(`[ERROR] UserModel.createUser :\n ${err}`)
    }
  }

  static async updateCoin(conn, userName, changeCoin) {
    const _userName = userName
    const _changeCoin = changeCoin
    const user = await this.selectUserByName(conn, _userName)
    const userCoin = user.userCoin
    const newCoin = userCoin + _changeCoin

    if (changeCoin == 0) throw new Error("changeCoin is zero.")
    if (newCoin < 0) throw new Error("userCoin will less than zero. Update failed")

    try {
      const query = `UPDATE user SET userCoin = '${newCoin}' WHERE userName = '${_userName}'`
      const [rows, fields] = await conn.execute(query)

      return _userName
    } catch (err) {
      console.error(`[ERROR] UserModel.updateCoin :\n ${err}`)
    }
  }
}
