import MapItemModel from "../../../models/mapItemModel";
import connectPool from '../../../database'

const mapItemMutations = {
    createMapItem: async (_, args) => {
        await MapItemModel.createMapItem(connectPool, args.mapItem)
        const mapItems = await MapItemModel.selectAll(connectPool)

        return mapItems
    }
}

export default mapItemMutations