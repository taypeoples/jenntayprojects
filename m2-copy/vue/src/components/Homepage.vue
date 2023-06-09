<template>
  <div class="home-container">
  <div class="daily-puzzle">Daily Puzzle
    <img class="daily-picture" src="dailypuzzle.png"/>
  </div>
  <div class="puzzle-levels">Puzzles by Level
    <img class="level-picture" src="puzzlelevel.png"/>
  </div>
  <div class="my-puzzles">My Saved Puzzles
    <img class="saved-picture" src="savedpuzzle.png"/>
  </div>
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
  gap: 20px 20px;
  grid-auto-flow: row;
  grid-template-areas:
    "daily-puzzle puzzle-levels my-puzzles"
    "daily-puzzle puzzle-levels my-puzzles"
    "daily-puzzle puzzle-levels my-puzzles";
}

.daily-puzzle { 
  grid-area: daily-puzzle; 
  background-color: lightblue;
  text-align: center;
  border: 3px solid black;
  border-radius: 15px;
  color: black;
  text-shadow: 2px 2px 2px yellow;
  text-transform: capitalize;
  padding-top: 30px;
  font-weight: bold;
  text-align: center;
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif
}

.puzzle-levels { grid-area: puzzle-levels;
background-color: lightcoral; 
text-align: center;
border: 3px solid black;
  border-radius: 15px;
  color: black;
  text-shadow: 2px 2px 2px yellow;
  text-transform: capitalize;
  padding-top: 30px;
  font-weight: bold;
  text-align: center;
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif
}


.my-puzzles { grid-area: my-puzzles; 
background-color: lightgreen;
text-align: center;
border: 3px solid black;
  border-radius: 15px;
  color: black;
  text-shadow: 2px 2px 2px yellow;
  text-transform: capitalize;
  padding-top: 30px;
  font-weight: bold;
  text-align: center;
  font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif
}

.saved-picture {
  display: block;
  margin-left: auto;
  margin-right: auto;
  margin-top: 30px;
  margin-bottom: 30px;
  width: 50%;
}

.daily-picture {
  display: block;
  margin-left: auto;
  margin-right: auto;
  margin-top: 30px;
  margin-bottom: 30px;
  width: 50%;
}

.level-picture {
display: block;
  margin-left: auto;
  margin-right: auto;
  margin-top: 30px;
  margin-bottom: 30px;
  width: 50%;
}
</style>