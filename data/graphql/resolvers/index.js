import { versionQueries } from './version'
import { userMutations, userQueries } from './user'
import { postMutations, postQueries } from './post'
import { userItemMutations, userItemQueries } from './item'

const resolvers = {
  Query: {
    ...versionQueries,
    ...userQueries,
    ...postQueries,
    ...userItemQueries
  },
  Mutation: {
    ...userMutations,
    ...postMutations,
    ...userItemMutations
  }
}

export default resolvers
