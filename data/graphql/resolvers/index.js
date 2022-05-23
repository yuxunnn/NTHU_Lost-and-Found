import { versionQueries } from './version'
import { userQueries } from './user'

const resolvers = {
  Query: {
    ...versionQueries,
    ...userQueries
  }
}

export default resolvers
