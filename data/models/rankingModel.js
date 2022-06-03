/* eslint-disable no-unused-vars */
export default class RankingModel {
    static async selectAll(conn) {
        try {
            const query = 'SELECT * FROM ranking ORDER BY score DESC'
            const [rows, fields] = await conn.execute(query)

            return rows
        } catch (err) {
            console.error(`[ERROR] RankingModel.selectAll :\n ${err}`)
        }
    }

    static async updateRanking(conn, NTHU, NCTU, NTU, NCCU) {
        const _nthu = NTHU
        const _nctu = NCTU
        const _ntu = NTU
        const _nccu = NCCU
        let query

        try {
            // Set NTHU score
            query = `UPDATE ranking SET score = '${_nthu}' WHERE school = "NTHU"`
            await conn.execute(query)

            // Set NCTU score
            query = `UPDATE ranking SET score = '${_nctu}' WHERE school = "NCTU"`
            await conn.execute(query)

            // Set NTU score
            query = `UPDATE ranking SET score = '${_ntu}' WHERE school = "NTU"`
            await conn.execute(query)

            // Set NCCU score
            query = `UPDATE ranking SET score = '${_nccu}' WHERE school = "NCCU"`
            await conn.execute(query)
        } catch (err) {
            console.error(`[ERROR] RankingModel.updateRanking :\n ${err}`)

        }
    }
}