import App from './App.vue'
import { createApp } from 'vue'
import router from './router'


const app = createApp(App)
app.use(router)
app.mount('#app')

//tried several variations but still receiving "Cannot read properties of undefined (reading 'use')
//TypeError: Cannot read properties of undefined (reading 'use')" Error
//possibly from: editing package.json file manually, axios issues, router not being setup properly