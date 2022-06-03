import { versionQueries } from './version'
import { userMutations, userQueries } from './user'
import { postMutations, postQueries } from './post'
import { userItemMutations, userItemQueries } from './item'
import { shopItemQueries } from './shopItem'
import { rankingQueries, rankingMutaions } from './ranking'
import { questQueries, questMutations } from './quest'
import { chatQueries, chatMutations } from './chat'

const resolvers = {
  Query: {
    ...versionQueries,
    ...userQueries,
    ...postQueries,
    ...userItemQueries,
    ...shopItemQueries,
    ...rankingQueries,
    ...questQueries,
    ...chatQueries
  },
  Mutation: {
    ...userMutations,
    ...postMutations,
    ...userItemMutations,
    ...rankingMutaions,
    ...questMutations,
    ...chatMutations
  }
}

export default resolvers
