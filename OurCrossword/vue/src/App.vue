<template>
  <div class="container">
    <nav>
      <router-link to="/home">Home </router-link>
      &nbsp; &nbsp;
      <router-link to="/account">My Account</router-link>
      &nbsp; &nbsp;
      <router-link to="/login">Login </router-link>
    </nav>
    <div class="main-view">
      <router-view />
    </div>
    <div class="footer">this is the footer</div>
  </div>
</template>


<script>
export default {
  components: {},
};
</script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 0.3fr 2.4fr 0.3fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "nav nav nav"
    "main-view main-view main-view"
    "footer footer footer";
}

.nav {
  grid-area: nav;
}

.main-view {
  grid-area: main-view;
  height: 100%;
}

.footer {
  grid-area: footer;
}
</style>