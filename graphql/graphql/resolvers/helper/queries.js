import HelperModel from "../../../models/helperModel";
import connectPool from '../../../database'

const helperQueries = {
    postHelpers: async (_, args) => {
        const helpers = await HelperModel.selectPostHelpers(connectPool, args.postId)

        return helpers
    }
}

export default helperQueries