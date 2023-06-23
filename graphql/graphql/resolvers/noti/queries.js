import NotiModel from "../../../models/notiModel";
import connectPool from '../../../database'

const notiQueries = {
    notiByName: async (_, args) => {
        const notis = await NotiModel.selectByUserName(connectPool, args.userName)

        return notis
    }
}

export default notiQueries