<template>
  <div class = "job">
    <the-header />
    <job-search />
  </div>
</template>

<script>
import JobSearch from "../components/JobSearch.vue";
import TheHeader from "../components/TheHeader.vue";
export default {
  components: { JobSearch, TheHeader },
};
</script>

<style scoped>
.job{
  height: 100%;
}
</style>