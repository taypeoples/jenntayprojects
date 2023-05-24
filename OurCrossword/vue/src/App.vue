<template>
  <div class="container">
    <!-- <div class="nav">
      <the-header />
    </div> -->
    <div class="body">
      <router-view />

    </div>
  </div>
</template>


<script>


export default {
  components: {
    /* TheHeader, */
  },
};
</script>

<style scoped>
/* .container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 0.2fr 1.3fr 1.5fr;
  gap: 0px 0px;
  grid-template-areas:
    "nav nav nav"
    "body body body"
    "body body body";
} */

/* .nav {
  background: #131313;
}
 */

</style>