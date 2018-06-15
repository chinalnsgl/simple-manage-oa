/*
 通过mutation间接更新state的多个方法的对象
 */
import {RECEIVE_PRODUCT, RECEIVE_PRODUCTS} from './mutation-type'
import {products} from '../api'

export default {
  async getProducts ({commit}, pageNo) {
    const result = await products(pageNo)
    if (result.code === 200) {
      const productsPage = result.data
      commit(RECEIVE_PRODUCTS, {productsPage})
    }
  }
}
