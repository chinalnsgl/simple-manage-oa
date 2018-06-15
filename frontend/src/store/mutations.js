/*
 直接更新state的多个方法的对象
 */
import {RECEIVE_PRODUCT, RECEIVE_PRODUCTS} from './mutation-type'

export default {
  [RECEIVE_PRODUCT] (state, {product}) {
    state.product = product
  },
  [RECEIVE_PRODUCTS] (state, {productsPage}) {
    state.productsPage = productsPage
  }
}
