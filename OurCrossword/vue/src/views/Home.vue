<template>
  <div>
</div>
</template>
<script>
import TheHeader from '../components/TheHeader.vue';
export default {
  components: { TheHeader },
  name: "home"
};
</script>

<style scoped>
body {
  font-family: fantasy;
  margin: 5 5;
  max-width: 1080px;
}

.home {
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  display: flex;
  background-image: linear-gradient(to top, 
    #4298df 0%, 
    #6aa5d6 20%, 
    #81b1f8 40%, 
    #ffffff 60%, 
    #ffffff 80%, 
    #ffffff 100%
  );
  flex-direction: column;
  align-items: center;
  min-height: 100%;
  max-width: 100%;
}

.home h1 {
  background-image: linear-gradient(to bottom, #3d3c3c,  #4298df);
  background-size: 100%;
  margin-bottom: 5rem;
  font-size: 5rem;
  -webkit-background-clip: text;
  -moz-background-clip: text;
  -webkit-text-fill-color: transparent;
  -moz-text-fill-color: transparent;
  padding-top: 100px;
}

p {
  margin-top: 1rem;
  font-size: 1.4rem;
  font-weight: 600;
  background-image: linear-gradient(to bottom, #302d2d,  #4298df);
  -webkit-background-clip: text;
  -moz-background-clip: text;
  -webkit-text-fill-color: transparent;
  -moz-text-fill-color: transparent;
}

.cards-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.floating-card:hover {
  transform: scale(1.05);
}

.floating-card1:hover {
  transform: scale(1.05);
}

.main__img--container {
    text-align: center;
}

.main__container {
    display: grid;
    grid-template-columns: 1fr 1fr;
    align-items: center;
    justify-self: center;
    margin: 0;
    height: 90vh;
    z-index: 1;
    width: 100%;
    height: 400px;
    max-width: 1000px;
    padding: 0 50px;
    padding-top: 50px;
    
}

.floating-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: 2rem;
  height: 525px;
  width: 400px;
  border-radius: 20px;
  background-image: linear-gradient(to bottom, rgba(255, 255, 255rgba(255, 255, 255, 0.6)7,17,0.6) 100%);
  background-size: cover;
  position: center;
  color: #fff;
  background-position: center;
  background-image: url('/pictures/Capture1.PNG');
  background-size: 150%;
  transition: transform 0.2s ease-in-out;
  text-align: center;
  box-shadow: rgb(54, 141, 192) 0 0 40px;
  animation: shadows 4s infinite
}

@keyframes shadows {
 0% { box-shadow: #ffffff 0 0 40px; }
 50% { box-shadow: rgb(55, 139, 196) 0 0 40px; }
 75% { box-shadow: rgb(255, 255, 255) 0 0 40px;}
 100% { box-shadow: #3899c0 0 0 40px; }
}


.floating-card1 {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: 2rem;
  height: 525px;
  width: 400px;
  border-radius: 20px;
  background-image: linear-gradient(to bottom, rgba(255, 255, 255rgba(255, 255, 255, 0.6)7,17,0.6) 100%);
  background-size: cover;
  position: relative;
  color: #fff;
  background-position: center;
  background-image: url('/pictures/Capture4.PNG');
  background-size: 250%;
  transition: transform 0.2s ease-in-out;
  text-align: center;
  box-shadow: rgb(54, 141, 192) 0 0 40px;
  animation: shadows 4s infinite;
}

.cards-container{
  padding-bottom: 150px;
}

#main__img {
    height: 60%;
    width: 80%;
}

.floating-card p {
  margin-bottom: 2rem;
  font-size: 2.5rem;
  background: linear-gradient(to bottom, #ffffff 0%, #ffffff 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  -webkit-text-stroke: .2px rgb(0, 0, 0);
}
.floating-card1 p {
  margin-bottom: 2rem;
  font-size: 2.5rem;
  background: linear-gradient(to bottom, #ffffff 0%, #ffffff 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  -webkit-text-stroke: .2px rgb(0, 0, 0);
}

.floating-card a {
  display: block;
  background-color: #1d1d1d;
  color: rgb(255, 255, 255);
  padding: 1rem 2rem;
  border-radius: 4px;
  text-decoration: none;
  font-weight: bold;
  transition: background-color 0.2s ease-in-out;
  margin-top: 2rem;
}

.floating-card1 a {
  display: block;
  background-color: #1d1d1d;
  color: rgb(255, 255, 255);
  padding: 1rem 2rem;
  border-radius: 4px;
  text-decoration: none;
  font-weight: bold;
  transition: background-color 0.2s ease-in-out;
  margin-top: 2rem;
}
.floating-card a:hover {
  background-color: #4298df;
}

.floating-card1 a:hover {
  background-color: #4298df;
}



@media only screen and (max-width: 1500px) {
  .home {
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  display: flex;
  background-image: linear-gradient(to top, 
    #4298df 0%, 
    #6aa5d6 20%, 
    #81b1f8 40%, 
    #ffffff 60%, 
    #ffffff 80%, 
    #ffffff 100%
  );
  flex-direction: column;
  align-items: center;
  min-height: 100%;
  min-width: 90%;
}

.home h1 {
  background-image: linear-gradient(to bottom, #3d3c3c,  #4298df);
  background-size: 100%;
  margin-bottom: 3rem;
  font-size: 3rem;
  -webkit-background-clip: text;
  -moz-background-clip: text;
  -webkit-text-fill-color: transparent;
  -moz-text-fill-color: transparent;
  padding-top: 20px;
}

p {
  margin-top: .5rem;
  font-size: 1rem;
  font-weight: 600;
  background-image: linear-gradient(to bottom, #302d2d,  #4298df);
  -webkit-background-clip: text;
  -moz-background-clip: text;
  -webkit-text-fill-color: transparent;
  -moz-text-fill-color: transparent;
}

.cards-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  width: 90%;
}

.floating-card:hover {
  transform: scale(1.05);
}

.floating-card1:hover {
  transform: scale(1.05);
}

.main__img--container {
    text-align: center;
    max-width: 50%;
}

.main__container {
    display: grid;
    grid-template-columns: 1fr 1fr;
    align-items: center;
    justify-self: center;
    margin: 0 auto;
    height: 90vh;
    z-index: 1;
    width: 90%;
    height: 400px;
    max-width: 1300px;
    padding: 0 50px;
    padding-top: 20px;
    padding-right: 0px;
}

#main__img {
  width: 50%;
}
}


@media only screen and (max-width: 600px) {
  #main__img {
    text-align: center;
    width: 0%;
}
}

.home {
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  display: flex;
  background-image: linear-gradient(to top, 
    #4298df 0%, 
    #6aa5d6 20%, 
    #81b1f8 40%, 
    #ffffff 60%, 
    #ffffff 80%, 
    #ffffff 100%
  );
  flex-direction: column;
  align-items: center;
  min-height: 100%;
  max-width: 100%;
}
</style>