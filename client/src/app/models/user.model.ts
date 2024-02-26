export type User = {
  firstName: string,
  lastName: string,
  birthday: string,
  email: string,
  phone: string,
  country: string,
  salary: number
}

export function createUser(
  firstName="",
  lastName="",
  birthday="",
  email="",
  phone="",
  country="",
  salary=0
): User{
  return {
    firstName,
    lastName,
    birthday,
    email,
    phone,
    country,
    salary
  }
}
