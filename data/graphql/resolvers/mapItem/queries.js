import MapItemModel from "../../../models/mapItemModel";
import connectPool from '../../../database'

const mapItemQueries = {
    mapItems: async (_, args) => {
        const mapItems = await MapItemModel.selectAll(connectPool)

        return mapItems
    }
}

export default mapItemQueries