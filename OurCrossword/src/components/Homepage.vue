<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div>
    <div class="container">
      <div class="nav"></div>
      <div class="footer"></div>
      <div class="dailypuzzle"></div>
      <div class="levelpuzzle"></div>
      <div class="mypuzzles"></div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 0.3fr 1.5fr 0.3fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "nav nav nav"
    "dailypuzzle levelpuzzle mypuzzles"
    "footer footer footer";
}

.nav {
  grid-area: nav;
}

.footer {
  grid-area: footer;
}

.dailypuzzle {
  grid-area: dailypuzzle;
}

.levelpuzzle {
  grid-area: levelpuzzle;
}

.mypuzzles {
  grid-area: mypuzzles;
}
</style>