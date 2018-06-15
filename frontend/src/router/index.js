import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/Home.vue'
import Login from '@/pages/Login.vue'
import Product from '../pages/Product.vue'
import Employee from '../pages/Employee.vue'
import Info from '../pages/Info.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: Login
    },
    {
      path: '/home',
      component: Home,
      children: [
        {
          path: '/product',
          component: Product
        },
        {
          path: '/employee',
          component: Employee
        },
        {
          path: '/info',
          component: Info
        }
      ]
    }
  ]
})
