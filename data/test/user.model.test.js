import UserModel from '../models/userModel'
import connectPool from '../database'

afterAll(() => {
  connectPool.end()
})

describe('[User.Model]', () => {
  const schema = {
    userId: expect.any(Number),
    userName: expect.any(String),
    userSchool: expect.any(String),
    userPhoneNumber: expect.any(String),
    userEmail: expect.any(String),
    userPassword: expect.any(String),
    createdAt: expect.any(Date),
    updatedAt: expect.any(Date)
  }
  const _userName = 'huiyuiui'
  const _userPhoneNumber = '0978500627'

  it('Select All User', async () => {
    const users = await UserModel.selectAll(connectPool)

    // Check Type
    expect(users).toMatchObject(expect.any(Array))
  })

  it('Select User', async () => {
    const users = await UserModel.selectAll(connectPool)
    const user = await UserModel.selectUser(connectPool, _userName)
    // Check Data
    expect(users).not.toBeUndefined()

    // Check Type
    expect(user).toMatchObject(schema)

    // Check Content
    expect(user.userName).toEqual(_userName)
    expect(user.userPhoneNumber).toEqual(_userPhoneNumber)
  })
})
