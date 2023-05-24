<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div>
    <div class="container">
      <div class="nav">
        <router-link :to="{ name: 'home' }">Home</router-link>
        &nbsp; &nbsp;
        <p>Account</p>
      </div>
      <div class="footer">About Us Contact Us</div>
      <div class="puzzle">this is a puzzle</div>
      <div class="clues">
        <ol class="clue-list" v-for="cword in cwords" :key="cword.id">
          <li>{{cword.clue}}</li>
        </ol>
      </div>
    </div>
  </div>
</template>

<script>
import cwordsService from "../services/CwordsService";


export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "crossword",
  data(){
    return{
      cwords: [],
    }
  },
  methods: {
    navigateHome() {
      this.$router.push({ name: "home" });
    },
  },
  created() {
    cwordsService.list().then((response) => {
      this.cwords = response.data;
    });
  },
};
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
    "clues puzzle puzzle"
    "footer footer footer";
}

.nav {
  grid-area: nav;
  border-bottom-style: solid;
  text-align: center;
}

.footer {
  grid-area: footer;
  border-top-style: solid;
  text-align: center;
}

.puzzle {
  display: flex;
  grid-area: puzzle;
  text-align: center;
  justify-content: center;
  align-items: center;
}

.clues {
  display: flex;
  grid-area: clues;
  border-right-style: solid;
  list-style: none;
  text-align: center;
  justify-content: center;
  align-items: center;
}

.clue-list {
  text-align: center;
  margin: 0px;
  padding: 0px;
}
</style>