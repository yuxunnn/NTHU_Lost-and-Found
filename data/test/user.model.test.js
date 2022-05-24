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
  const createUserName = 'zun'
  const createUserSchool = 'NTHU'
  const createUserPhoneNumber = '09xxxxxxxx'
  const createUserEmail = 'chen1741954267@gmail.com'
  const createUserPassword = '20010915'
  let _userId

  it('Create User', async () => {
    _userId = await UserModel.createUser(connectPool,
      {
        userName: createUserName,
        userSchool: createUserSchool,
        userPhoneNumber: createUserPhoneNumber,
        userEmail: createUserEmail,
        userPassword: createUserPassword
      })
    const user = await UserModel.selectUserById(connectPool, _userId)

    // Check Data
    expect(user).not.toBeUndefined()

    // Check Content
    expect(user.userName).toEqual(createUserName)
    expect(user.userSchool).toEqual(createUserSchool)
    expect(user.userPhoneNumber).toEqual(createUserPhoneNumber)
    expect(user.userEmail).toEqual(createUserEmail)
    expect(user.userPassword).toEqual(createUserPassword)
  })

  it('Select All User', async () => {
    const users = await UserModel.selectAll(connectPool)

    // Check Type
    expect(users).toMatchObject(expect.any(Array))
  })

  it('Select User', async () => {
    const users = await UserModel.selectAll(connectPool)
    const user = await UserModel.selectUserById(connectPool, _userId)
    // Check Data
    expect(users).not.toBeUndefined()

    // Check Type
    expect(user).toMatchObject(schema)

    // Check Content
    expect(user.userName).toEqual(createUserName)
    expect(user.userPhoneNumber).toEqual(createUserPhoneNumber)
  })
})
