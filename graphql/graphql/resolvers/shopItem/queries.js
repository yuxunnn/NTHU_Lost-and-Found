import ShopItemModel from "../../../models/shopItemModel";
import connectPool from '../../../database'

const shopItemQueries = {
    shopItems: async (_, args) => {
        const shopItems = await ShopItemModel.selectAll(connectPool)

        return shopItems
    },
    shopItem: async (_, args) => {
        const shopItem = await ShopItemModel.selectShopItem(connectPool, args.itemType)

        return shopItem
    }
}

export default shopItemQueries