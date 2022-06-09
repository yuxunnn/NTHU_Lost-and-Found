import NotiModel from "../../../models/notiModel";
import connectPool from '../../../database'

const notiMutations = {
    createNoti: async (_, args) => {
        await NotiModel.createNoti(connectPool, args.noti)
        const notis = await NotiModel.selectByUserName(connectPool, args.noti.receive)

        return notis
    }
}

export default notiMutations