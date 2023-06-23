/* eslint-disable no-unused-vars */
export default class ShopItemModel {
    static async selectAll(conn) {
        try {
            const query = `SELECT * FROM shopitem`
            const [rows, fields] = await conn.execute(query)

            return rows
        } catch (err) {
            console.error(`[ERROR] ShopItemModel.selectAll :\n ${err}`)
        }
    }

    static async selectShopItem(conn, itemType) {
        const _itemType = itemType

        try {
            const query = `SELECT * FROM shopitem WHERE itemType = '${_itemType}'`
            const [rows, fields] = await conn.execute(query)

            return rows[0]
        } catch (err) {
            console.error(`[ERROR] ShopItemModel.selectShopItem :\n ${err}`)
        }
    }
}