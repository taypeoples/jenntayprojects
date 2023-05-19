import Homepage from './components/Homepage.vue'
import Crossword from './components/Crossword.vue'

const routes = [
    {
        path: '/home',
        name: 'home',
        component: Homepage
    },
    {
        path: '/crossword',
        name: 'crossword',
        component: Crossword
    }
];