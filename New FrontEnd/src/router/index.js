import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/Home";
import GraduateDetails from "../views/GraduateDetails";
import NotFound from "../views/NotFound";
import SignIn from '@/components/SignIn'
import SignUpGraduate from '@/components/SignUpGraduate'
import SignUpStudent from '@/components/SignUpStudent'
import Announcements from '../views/Announcements'

//import CreatePost from '@/components/CreatePost'
import Start from '@/components/Start'

import PostAnouncement from '@/components/PostAnouncement'
Vue.use(VueRouter);
export default new VueRouter({
routes : [
  //Login
  {
    name: "Home",
    path: "/Home",
    component: Home,
    meta: {
      item: null,
      module: {
        id: null,
      },
      title: "Home",
    },
  },
  {
    name: "Details",
    path: "/details",
    component: GraduateDetails,
    meta: {
      item: null,
      module: {
        id: null,
      },
      title: "Details",
    },
  },
  //404
  {
    name: "NotFound",
    path: "*",
    component: NotFound,
    meta: {
      item: null,
      module: {
        id: null,
      },
      title: "Not FOund",
    },
  },
  {
    name: "SignIn",
    path: "/SignIn",
    component: SignIn,
    meta: {
      item: null,
      module: {
        id: null,
      },
      title: "SignIn",
  },
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
    path: '/PostAnouncement',
    name: 'PostAnouncement',
    component: PostAnouncement 
  },
  {
    path: '/',
    name: 'Start',
    component: Start 
  },
  {
    path: '/Announcements',
    name: "Announcements",
    component: Announcements 
  },/*
  {
  path: '/CreatePost',
  name: "CreatePost",
  component: CreatePost 
  },*/
]
})



