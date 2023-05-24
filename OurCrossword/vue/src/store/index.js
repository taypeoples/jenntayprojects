import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    nickname: '',
    needCategory: 'default',
    keyword1: 'default',
    keyword2: 'default',
    allKeywords: ['pathway', 'curriculum', 'resume', 'interview', 'cover', 'letter', 'parts', 'component', 'components', 'part', 'links', 'link', 'back', 'home', 'prep', 'prepare', 'follow', 
    'up', 'star', 'questions', 'question', 'outfit', 'dress', 'clothes', 'clothing', 'java', 'client', 'server', 'web', 'app', 'database', 'data', 'base', 'databases', 'variables', 'variable', 
    'arrays', 'array', 'collections', 'collection', 'unit', 'testing', 'test', 'oop', 'object', 'oriented', 'api', 'dao', 'networking', 'network', 'css', 'style', 'html', 'javascript', 
    'script', 'vue', 'sql', 'sequel', 'design', 'security', 'assistance']
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_NICKNAME(state, nickname) {
      state.nickname = nickname;
    },
    SET_NEED_CATEGORY(state, needCategory){
      state.needCategory = needCategory;
    },
    SET_KEYWORD1(state,keyword1){
      state.keyword1 = keyword1;
    },
    SET_KEYWORD2(state, keyword2){
      state.keyword2 = keyword2;
    }
  }
})
