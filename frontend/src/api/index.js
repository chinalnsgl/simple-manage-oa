import ajax from './ajax'

const BASE_URL = 'http://localhost:8080'

// login
export const login = (account, password) => ajax(BASE_URL + '/login', {account, password})
export const products = pageNo => ajax(BASE_URL + '/product/products', {pageNo})
