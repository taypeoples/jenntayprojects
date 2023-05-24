import axios from 'axios';

export default {

  catPic(){

    const options = {
        method: 'GET',
        url: 'https://api.thecatapi.com/v1/images/search',
      };




    return axios.request(options);
  }

}