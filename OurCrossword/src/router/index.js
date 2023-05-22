/* import Vue from 'vue';
import VueRouter from 'vue-router';
import Homepage from '../components/Homepage.vue';
import Crossword from '../components/Crossword.vue';
import UserAccount from '../components/UserAccount.vue';

Vue.use(VueRouter);
const routes = [
    {
        path: '/',
        name: 'home',
        component: Homepage
    },
    {
        path: '/crossword',
        name: 'crossword',
        component: Crossword
    },
    {
        path: '/account',
        name:'account',
        component: UserAccount
    }
]
const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})
export default router
; */



import * as Vue from 'vue';
import * as VueRouter from 'vue-router';
import App from '../App.vue'
import Homepage from '../components/Homepage.vue';
import Crossword from '../components/Crossword.vue';
import UserAccount from '../components/UserAccount.vue';

const routes = [
    {
        path: '/',
        name: 'home',
        component: Homepage
    },
    {
        path: '/crossword',
        name: 'crossword',
        component: Crossword
    },
    {
        path: '/account',
        name:'account',
        component: UserAccount
    }
];

const router = VueRouter.createRouter({
  history: VueRouter.createWebHistory(),
  routes,
});

Vue.createApp(App).use(router).mount('#app');