<template>
  <div>
<p> test push </p>
<h1>Picture of Day</h1>
      <button v-on:click="getCatPic">Click here</button>
      <p>{{catPic[0]}}</p>
       <img v-bind:src="catPic.url" alt="">

  </div>
</template>

<script>
import CatService from "../services/CatService.js"


export default {
    data() {
        return {
            catPicArray: [],
            catPic: {}
            
        

        }
    },
    methods:{
        getCatPic(){
            CatService.catPic().then(response => {
                this.catPicArray = response.data;
                this.catPic = this.catPicArray[0]
            })
        }
    }

}
</script>

<style>

</style>