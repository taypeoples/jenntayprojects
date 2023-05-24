<template>
  <div class="jsearch">
    <div class="job-search-form">
      <div class="right">
        <h5>Search Filter:</h5>
        <form>
          <div>
            <label for="jtitle" class="text-center"></label><br />
            <input
              v-model="jobTitle"
              type="text"
              id="jtitle"
              name="jtitle"
              placeholder="Job Title"
            />
          </div>
          <div>
            <label for="location" class="text-center"></label><br />
            <input
              v-model="location"
              type="text"
              id="location"
              name="location"
              placeholder="Location"
            />
          </div>
          <div class="">
            <p>Job Type:</p>
            <div class="checkbox-group">
              <input
                v-model="jobType"
                type="checkbox"
                id="ftime"
                name="ftime"
                value="Full-time"
              />
              <label for="ftime">Full-time</label><br />
              <input
                v-model="jobType"
                type="checkbox"
                id="ptime"
                name="ptime"
                value="Part-time"
              />
              <label for="ptime">Part-time</label><br />
              <input
                v-model="jobType"
                type="checkbox"
                id="internship"
                name="internship"
                value="Internship"
              />
              <label for="internship">Internship</label><br />
              <input
                v-model="jobType"
                type="checkbox"
                id="contract"
                name="contract"
                value="Contractor"
              />
              <label for="contract">Contractor</label><br /><br />
            </div>
            <div>
              <label for="remote">Remote-Only:</label>
              <input v-model="remote" type="checkbox" id="remote" />
            </div>
          </div>
        </form>
      </div>
      <div class="right2">
        <button v-on:click="populateJobsArray">Search for jobs</button>
      </div>
    </div>
    <br />
    <div class="job-cards-container">
      <div v-for="job in jobs" :key="job.id" class="job-card">
        <div class="card-header">{{ job.employer_name }}</div>
        <div class="card-body">
          <h5 class="card-title">{{ job.job_title }}</h5>
          <pre class="card-text">{{ job.job_description }}</pre>
          <a :href="job.job_apply_link" target="_blank" class="btn-primary"
            >Apply</a
          >
        </div>
        <div class="card-footer text-muted">{{ job.job_location }}</div>
      </div>
    </div>
  </div>
</template>
  
<script>
import JobService from "../services/JobService.js";
export default {
  data() {
    return {
      jobs: [],
      jobTitle: "",
      location: "",
      jobType: [],
      remote: false,
      updatedDescription: "",
      title: 'Job Search'
    };
  },

  mounted(){
    document.title = this.title;
  },

  created() {
    // turned this off because we only get so many calls per month, can turn back on if we decide to go this way with design implemented button instead.
    //Can also create second account if we hit too many calls lol
    /* this.populateJobsArray(); */
  },

  methods: {
    populateJobsArray() {
      JobService.getJobs(
        this.jobTitle,
        this.location,
        this.jobType,
        this.remote
      ).then((response) => {
        this.jobs = response.data.data;
      });
    },
  },
};
</script>

<style scoped>
.jsearch {
  background-image: url(https://i.imgur.com/QlpP1vV.png);
  background-size: auto;
  padding-top: 40px;
  height: 100%;
  margin: 0;
}

.job-cards {
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  text-align: center;
}

.job-card {
  margin: 10px;
  background-color: white;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
  border-radius: 5px;
  overflow: auto;
  display: inline-block;
  max-width: 600px;
  max-height: 600px;
  min-height: 600px;
  min-width: 600px;
}

.job-card:hover {
  box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.card-body {
  padding: 10px;
}

pre {
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  white-space: pre-wrap;
  padding: 10px;
}

.btn-primary {
  box-shadow: 0px 0px 0px 2px #9fb4f2;
  background: linear-gradient(to bottom, #7892c2 5%, #476e9e 100%);
  background-color: #7892c2;
  border-radius: 10px;
  border: 1px solid #4e6096;
  display: inline-block;
  cursor: pointer;
  color: #ffffff;
  font-family: Arial;
  font-size: 19px;
  padding: 12px 37px;
  text-decoration: none;
  text-shadow: 0px 1px 0px #283966;
}
.btn-primary:hover {
  background: linear-gradient(to bottom, #476e9e 5%, #7892c2 100%);
  background-color: #476e9e;
}
.btn-primary:active {
  position: relative;
  top: 1px;
}

.card-header {
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  background-color: #3b5998;
  color: white;
  padding: 10px;
  font-weight: bold;
  font-size: large;
}

.card-footer {
  background-color: #f7f7f7;
  padding: 10px;
  text-align: center;
}

.card-title{
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  font-size: large;
  font-weight: bold;
}

/* Form Styling */
body {
  background-image: linear-gradient(135deg, #fab2ff 10%, #1904e5 100%);
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
  font-family: "Open Sans", sans-serif;
  color: #333333;
}

button {
  background-color: #3b5998;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 10px;
  cursor: pointer;
}

button:hover {
  background-color: #237aec;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 10px;
  cursor: pointer;
}

.job-search-form {
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  font-size: medium;
  padding-top: 20px;
  margin: 0 auto;
  width: 50%;
  height: 50%;
  background: #ffffffd0;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 0 20px 6px #2759c585;
}

@media (max-width: 980px) {
  .job-search-form {
    flex-flow: wrap;
    align-content: left;
    align-items: left;
    width: 90%;
  height: 50%;
  }

  .job-card {
    min-height: 90%;
    min-width: 90%;
  }
}

.job-search-form div {
  height: auto;
}

.job-search-form .right {
  padding: 20px;
  overflow: hidden;
}

@media (max-width: 480px) {
  .job-search-form {
    width: 90%;
    height: 40%;
  }
  .job-card {
    min-height: 90%;
    min-width: 90%;
    max-height: 90%;
    max-width: 90%;
  }
}

.job-search-form .right h5 {
  font-size: 2vmax;
  line-height: 1;
  /* background-image: url("/pictures/Capture3.PNG"); */
  background-clip: text;
  -webkit-background-clip: text;
  color: #3b5998;
  margin-top: 10px;
  margin-bottom: 10px;
}

.job-search-form .right p {
  font-size: 14px;
  color: #b0b3b9;
}

.job-search-form .right .inputs {
  overflow: hidden;
}

.checkbox-group {
  text-align: left;
}

#jtitle {
  width: 50%;
}

#location {
  width: 50%;
}

.job-search-form .right input[type="text"] {
  border: none;
  outline: none;
  border-bottom: 2px solid #b0b3b9;
  width: 100%;
  padding: 10px 0;
  font-size: 18px;
}
.job-search-form .right input[type="submit"] {
  background: #3b5998;
  color: #ffffff;
  border: none;
  outline: none;
  padding: 10px;
  border-radius: 50px;
  font-size: 18px;
  cursor: pointer;
  box-shadow: 0 3px 6px;
}

.job-search-form {
  display: grid;
  grid-template-rows: 1fr 0.2fr;
  grid-template-columns: 1fr;
  grid-template-areas:
    "right"
    "right2";
  gap: 0px 0px;
  height: 50%;
}

.right {
  grid-area: "right";
}
.right2 {
  grid-area: "right2";
  align-self: center;
  padding: 20px;
}
</style>