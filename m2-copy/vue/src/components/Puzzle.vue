<template>
  <div class="puzzle-container">
    <div class="clues">
  
      <ol>
        <li v-for="crossword in crosswords" v-bind:key="crossword.id">{{ crossword.word}}</li>
        <li>clue one</li>
        <li>clue two</li>
      </ol>
    </div>
    <div class="crossword">empty crossword</div>
  </div>
</template>

<script>
import CrosswordsService from "../services/CrosswordsService.js";
export default {
  name: "puzzle",
  data() {
    return {
      crosswords: [],
    }
  },
  methods: {},
  created() {
    CrosswordsService.listWords().then((response) => {
      this.crosswords = response.data;
    });
  },
};
</script>

<style>
.puzzle-container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "clues crossword crossword"
    "clues crossword crossword"
    "clues crossword crossword";
}

.clues {
  grid-area: clues;
}

.crossword {
  grid-area: crossword;
  
}
</style>