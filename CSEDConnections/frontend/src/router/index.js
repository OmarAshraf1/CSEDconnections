import Vue from 'vue'
import Router from 'vue-router'
import SignIn from '@/components/SignIn'
import SignUpGraduate from '@/components/SignUpGraduate'
import SignUpStudent from '@/components/SignUpStudent'
import Start from '@/components/Start'
import DisplayGraduates from '@/components/DisplayGraduates'
import GraduateProfile from '@/components/GraduateProfile'

Vue.use(Router)

export default new Router({
    routes: [
      {
        path: '/GraduateProfile',
        name: 'GraduateProfile',
        component: GraduateProfile
      },
      {
        path: '/DisplayGraduates',
        name: 'DisplayGraduates',
        component: DisplayGraduates
      },
      {
        path: '/SignIn',
        name: 'SignIn',
        component: SignIn
      },
      {
        path: '/SignUpGraduate',
        name: 'SignUpGraduate',
        component: SignUpGraduate
      },
      {
        path: '/SignUpStudent',
        name: 'SignUpStudent',
        component: SignUpStudent 
      },
      {
        path: '/',
        name: 'Start',
        component: Start 
      },
    ]
  })
