/* eslint-disable no-unused-vars */
export default class MapItemModel {
    static async selectAll(conn) {
        try {
            const query = `SELECT * FROM mapitem`
            const [rows, fields] = await conn.execute(query)

            return rows
        } catch (err) {
            console.error(`[ERROR] MapItemModel.selectAll :\n ${err}`)
        }
    }

    static async createMapItem(conn, args) {
        const _itemType = args.itemType
        const _latitude = args.latitude
        const _longitude = args.longitude
        const _userName = args.userName
        const _userSchool = args.userSchool

        try {
            const query = `INSERT INTO mapitem(itemType, latitude, longitude, userName, userSchool) VALUES('${_itemType}', '${_latitude}', '${_longitude}', '${_userName}', '${_userSchool}')`
            const [rows, fields] = await conn.execute(query)
        } catch (err) {
            console.error(`[ERROR] MapItemModel.createMapItem :\n ${err}`)
        }
    }
}