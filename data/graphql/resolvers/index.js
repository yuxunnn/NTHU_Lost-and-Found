import { versionQueries } from './version'
import { userMutations, userQueries } from './user'
import { postMutations, postQueries } from './post'

const resolvers = {
  Query: {
    ...versionQueries,
    ...userQueries,
    ...postQueries
  },
  Mutation: {
    ...userMutations,
    ...postMutations
  }
}

export default resolvers
