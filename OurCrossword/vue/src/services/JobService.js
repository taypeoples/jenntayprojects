import axios from "axios";



export default {


  //jsearch api 
  // good but may need to pay for 1 month so that we can do all the searches we need while working on this 
  // or create a bunch of fake email addresses and swap out the key
  // primary key that hit its limit:
  // 14fe3c00dfmsh014a33ce133cd06p1d9bc9jsna547623318d1


  // key for secondary account when we want to test:
  // 1b4f580bcdmshdfcfba45a52a733p157bcfjsn6f674d11d064

  //tay
  //7a240f4c7cmshd10db6ca82c9943p17f33bjsn032803b9b5bd
  getJobs(jobTitle, location, jobType, remote) {

    const options = {
      method: 'GET',
      url: 'https://jsearch.p.rapidapi.com/search',
      params: { query: `${jobTitle} in ${location}`, employment_types: jobType, remote_jobs_only: remote, page: '1', num_pages: '1', job_requirements: 'under_3_years_experience, no_experience' },
      headers: {
        'X-RapidAPI-Key': '1b4f580bcdmshdfcfba45a52a733p157bcfjsn6f674d11d064',
        'X-RapidAPI-Host': 'jsearch.p.rapidapi.com'
      }
    };

    return axios.request(options)
  },

  getAFewJobs() {

    const options = {
      method: 'GET',
      url: 'https://jsearch.p.rapidapi.com/search',
      params: {query: 'Junior Software Developer in Ohio, USA', page: '1', num_pages: '1'},
      headers: {
        'X-RapidAPI-Key': '1b4f580bcdmshdfcfba45a52a733p157bcfjsn6f674d11d064',
        'X-RapidAPI-Host': 'jsearch.p.rapidapi.com'
      }
    };

    return axios.request(options)
  },


}