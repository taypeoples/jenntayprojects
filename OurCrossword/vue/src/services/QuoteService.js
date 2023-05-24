import axios from 'axios';

export default {

  quote() {
    return axios.get('/quote')
  }

}
