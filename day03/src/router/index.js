import Vue from 'vue'
import Router from 'vue-router'

import registerpage from '@/components/registerpage'
import loginpage from '@/components/loginpage'
import homepage from '@/components/homepage'
import tiezineibupage from '@/components/tiezineibupage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/registerpage',
      name: 'registerpage',
      component: registerpage
    },
    {
      path: '/',
      name: 'loginpage',
      component: loginpage
    },
    {
      path: '/homepage',
      name: 'homepage',
      component: homepage
    },
    {
      path: '/tiezineibupage',
      name: 'tiezineibupage',
      component: tiezineibupage
    },
  ]
})
