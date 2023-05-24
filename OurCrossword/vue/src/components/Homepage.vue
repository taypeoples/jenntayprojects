<template>
  <div class="home-container">
  <div class="daily-puzzle">daily puzzles live here</div>
  <div class="puzzle-levels">pick a puzzle by level</div>
  <div class="my-puzzles">go to my saved puzzles</div>
</div>
</template>

<script>
export default {

}
</script>

<style>
.home-container {  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  gap: 0px 0px;
  grid-auto-flow: row;
  grid-template-areas:
    "daily-puzzle puzzle-levels my-puzzles"
    "daily-puzzle puzzle-levels my-puzzles"
    "daily-puzzle puzzle-levels my-puzzles";
}

.daily-puzzle { grid-area: daily-puzzle; }

.puzzle-levels { grid-area: puzzle-levels; }

.my-puzzles { grid-area: my-puzzles; }

</style>