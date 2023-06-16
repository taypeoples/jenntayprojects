<template>
  <div class="puzzle-container">
    <div class="clues">
      <ol>
        <li v-for="crossword in crosswords" v-bind:key="crossword.id">
          {{ crossword.word }}
        </li>
        <li>
          clue one more text here to test out auto spacing of clues container
        </li>
        <li>clue two</li>
      </ol>
    </div>
    <div class="crossword">
      empty crossword
      <form class="parent-grid"></form>
    </div>
  </div>
</template>

<script>
import CrosswordsService from "../services/CrosswordsService.js";
export default {
  name: "puzzle",
  data() {
    return {
      crosswords: [],
    };
  },
  methods: {
    cellSelected() {
      let cellClicked = document.querySelector(".lettercell");
      cellClicked.se;
    },
  },
  created() {
    CrosswordsService.listWords().then((response) => {
      this.crosswords = response.data;
    });
  },
  mounted() {
    let cell = document.querySelector(".parent-grid");
    for (let i = 1; i <= 625; i++) {
      let child = document.createElement("input");
      child.className = "lettercell";
      child.setAttribute("maxlength", "1");
      child.setAttribute("style", "text-transform:uppercase");

      cell.append(child);
    }
  },
};
</script>

<style>
.puzzle-container {
  display: grid;
  grid-template-columns: 1fr auto auto;
  grid-template-rows: 1fr 1fr 1fr;
  gap: 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "clues crossword crossword"
    "clues crossword crossword"
    "clues crossword crossword";
}

.clues {
  grid-area: clues;
  margin-right: 25px;
}

.crossword {
  grid-area: crossword;
  margin: 10px;
}

.parent-grid {
  display: grid;
  grid-template-rows: repeat(25, auto);
  grid-template-columns: repeat(25, auto);
  border: 2px;
  border-color: black;
  border-style: solid;
}

.lettercell {
  border: 1px;
  border-style: solid;
  border-color: black;
  padding: 4px;
  height: 40px;
  width: 40px;
  font-size: xx-large;
  text-align: center;
}

input:focus {
  background: lightgoldenrodyellow;
}
</style>