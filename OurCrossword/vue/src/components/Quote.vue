<template>
  <div>
      <h1> Quote:</h1>
      <p>{{Quote.text}} --{{Quote.author}}</p>
      <button v-on:click="getQuote">Click here</button>
  </div>
</template>

<script>

import QuoteService from '../services/QuoteService.js'
export default {
data(){
    return{
        Quote : {
            text: '',
            author: ''
        }
    }
},
methods: {
    getQuote(){
        QuoteService.quote().then((response)=>{
            this.Quote.text = response.data.quoteText;
            this.Quote.author = response.data.author;
        })
    }
}
}
</script>

<style>

</style>