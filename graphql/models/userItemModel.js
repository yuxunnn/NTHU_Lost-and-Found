/* eslint-disable no-unused-vars */
export default class UserItemModel {
    static async selectAll(conn) {
        try {
            // Return All Items
            const query = `SELECT * FROM useritem`
            const [rows, fields] = await conn.execute(query)

            return rows
        } catch (err) {
            console.error(`[ERROR] UserItemModel.selectAll :\n ${err}`)
        }
    }

    static async selectUserItem(conn, userName) {
        const _userName = userName

        try {
            // Return item
            const query = `SELECT * FROM useritem WHERE userName = '${_userName}'`
            const [rows, fields] = await conn.execute(query)

            return rows[0]
        } catch (err) {
            console.error(`[ERROR] UserItemModel.selectUserItem :\n ${err}`)
        }
    }

    static async updateUserItem(conn, args) {
        const _userName = args.userName
        const _itemType = args.itemType
        const _changeNum = args.changeNum
        const _userItem = await this.selectUserItem(conn, _userName)
        let _itemCount

        if (_changeNum == 0)
            throw new Error("changeNum is zero")

        try {
            switch (_itemType) {
                case "orangeFlag":
                    _itemCount = _userItem.orangeFlag + _changeNum
                    if (_itemCount < 0) throw new Error("orangeFlag less than zero")
                    break
                case "purpleFlag":
                    _itemCount = _userItem.purpleFlag + _changeNum
                    if (_itemCount < 0) throw new Error("purpleFlag less than zero")
                    break
                case "yellowFlag":
                    _itemCount = _userItem.yellowFlag + _changeNum
                    if (_itemCount < 0) throw new Error("yellowFlag less than zero")
                    break
                case "blueFlag":
                    _itemCount = _userItem.blueFlag + _changeNum
                    if (_itemCount < 0) throw new Error("blueFlag less than zero")
                    break
                case "shit":
                    _itemCount = _userItem.shit + _changeNum
                    if (_itemCount < 0) throw new Error("shit less than zero")
                    break
                case "vaccine":
                    _itemCount = _userItem.vaccine + _changeNum
                    if (_itemCount < 0) throw new Error("vaccine less than zero")
                    break
                default:
                    throw new Error("itemType not exist")
            }

            const query = `UPDATE useritem SET ${_itemType} = '${_itemCount}' WHERE userName = '${_userName}'`
            const [rows, fields] = await conn.execute(query)

            return _userName
        } catch (err) {
            console.error(`[ERROR] UserItemModel.updateUserItem :\n ${err}`)
        }
    }

    static async createUserItem(conn, args) {
        const _userName = args.userName

        try {
            const query = `INSERT INTO useritem(userName, orangeFlag, purpleFlag, yellowFlag, blueFlag, shit, vaccine) VALUES ('${_userName}', 0, 0, 0, 0, 0, 0)`
            const [rows, fields] = await conn.execute(query)

            return _userName
        } catch (err) {
            console.error(`[ERROR] UserItemModel.createUserItem :\n ${err}`)
        }
    }

    static async deleteuserItem(conn, args) {
        const _userName = args.userName

        try {
            const query = `DELETE FROM useritem WHERE userName = '${_userName}'`
            const [rows, fields] = await conn.execute(query)

            return `Delete userItem '${_userName}' successful!`
        } catch (err) {
            console.error(`[ERROR] UserItemModel.deleteuserItem :\n ${err}`)
        }
    }

}
