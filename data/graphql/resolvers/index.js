import { versionQueries } from './version'
import { userMutations, userQueries } from './user'

const resolvers = {
  Query: {
    ...versionQueries,
    ...userQueries
  },
  Mutation: {
    ...userMutations
  }
}

export default resolvers
