import axios from 'axios';

export default {
  getBotResponse(keyword1, keyword2){
    return axios.get(`/messages/${keyword1}/${keyword2}`);
  },

  sendMessage(userMessage){
    return axios.post('/messages', userMessage);
  },

  getFirstResponse(){
    return axios.get('/firstResponse');
  },
}