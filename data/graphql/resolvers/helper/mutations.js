import HelperModel from "../../../models/helperModel";
import connectPool from '../../../database'

const helperMutations = {
    createPostHelper: async (_, args) => {
        const rtn = await HelperModel.createPostHelper(connectPool, args)

        return rtn
    }
}

export default helperMutations