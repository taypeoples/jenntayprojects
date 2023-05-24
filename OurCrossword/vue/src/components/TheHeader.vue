<template>
  <nav class="navbar">
    <div class="navbar-container container">
      <h1 class="logo">ChatTErbot</h1>
      <input type="checkbox" id="navbar-toggle" class="navbar-toggle">
      <label for="navbar-toggle" class="hamburger-lines">
        <span class="line line1"></span>
        <span class="line line2"></span>
        <span class="line line3"></span>
      </label>
      <ul class="menu-items">
        <li><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
        <li><router-link v-bind:to="{ name: 'chatBot' }">ChatTErbot</router-link></li>
        <li><router-link v-bind:to="{ name: 'jobSearch' }">Job Search</router-link></li>
        <li v-if="$store.state.token == ''"><router-link v-bind:to="{ name: 'login' }">Login</router-link></li>
        <li v-if="$store.state.token != ''"><router-link v-bind:to="{ name: 'logout' }">Logout</router-link></li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
    name: 'the-header',
    data() {
        return {}
    }
};
</script>

<style scoped>
  *,
*::after,
*::before{
    box-sizing: border-box;
    padding: 0;
    margin: 0;
}
body {
  margin: 0;
  padding: 0;
}
.navbar {
  margin-top: 0;
  padding-top: 0;
}

.html{
    font-size: 62.5%;
}

.navbar input[type="checkbox"],
.navbar .hamburger-lines{
    display: none;
}

.container{
    max-width: 1200px;
    width: 90%;
    margin: auto;
}

.navbar{
    box-shadow: 0px 5px 10px 0px #aaa;
    width: 100%;
    background: #fff;
    color: #000;
    z-index: 999;
}

.navbar-container{
    display: flex;
    justify-content: space-between;
    height: 64px;
    align-items: center;
    
}

.menu-items{
    order: 2;
    display: flex;
}
.logo{
  order: 1;
  font-size: 2.3rem;
  background-position: 50% ;
  background-image: url('/pictures/Capture3.PNG');
  background-clip: text;
  -webkit-background-clip: text;
  color: transparent;
}

.menu-items li{
    list-style: none;
    margin-left: 1.5rem;
    font-size: 1.3rem;
}

.navbar a{
    color: #000000;
    text-decoration: none;
    font-weight: 500;
    position: relative;
}

.navbar a:after {
    content: "";
    position: absolute;
    left: 0;
    bottom: -2px;
    width: 0%;
    height: 2px;
    background-color: #2b88c7;
    transition: width 0.6s ease-in-out;
}

.navbar a:hover:after{
    width: 100%;
}

.navbar a:hover{
    text-decoration: none;
    color: #2b88c7;
}



@media (max-width: 768px){
    .navbar{
        opacity: 1.00;
    }

    .navbar-container input[type="checkbox"],
    .navbar-container .hamburger-lines{
        display: block;
    }

    .navbar-container{
        display: block;
        position: relative;
        height: 64px;
    }

    .navbar-container input[type="checkbox"]{
        position: absolute;
        display: block;
        height: 32px;
        width: 30px;
        top: 20px;
        left: 20px;
        z-index: 5;
        opacity: 0;
        cursor: pointer;
    }

    .navbar-container .hamburger-lines{
        display: block;
        height: 28px;
        width: 35px;
        position: absolute;
        top: 20px;
        left: 20px;
        z-index: 2;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
    }

    .navbar-container .hamburger-lines .line{
        display: block;
        height: 4px;
        width: 100%;
        border-radius: 10px;
        background: #333;
    }
    
    .navbar-container .hamburger-lines .line1{
        transform-origin: 0% 0%;
        transition: transform 0.3s ease-in-out;
    }

    .navbar-container .hamburger-lines .line2{
        transition: transform 0.2s ease-in-out;
    }

    .navbar-container .hamburger-lines .line3{
        transform-origin: 0% 100%;
        transition: transform 0.3s ease-in-out;
    }

    .navbar .menu-items{
        background: #fff;
        height: 100vh;
        max-width: 300px;
        transform: translate(-150%);
        display: flex;
        flex-direction: column;
        margin-left: -40px;
        padding-left: 40px;
        transition: transform 0.5s ease-in-out;
        box-shadow:  5px 0px 10px 0px #aaa;
        overflow: scroll;
    }

    .navbar .menu-items li{
        margin-bottom: 1.8rem;
        font-size: 1.1rem;
        font-weight: 500;
    }

    .logo{
        position: absolute;
        top: 10px;
        right: 15px;
        font-size: 2.5rem;
    }

    .navbar-container input[type="checkbox"]:checked ~ .menu-items{
        transform: translateX(0);
    }

    .navbar-container input[type="checkbox"]:checked ~ .hamburger-lines .line1{
        transform: rotate(45deg);
    }

    .navbar-container input[type="checkbox"]:checked ~ .hamburger-lines .line2{
        transform: scaleY(0);
    }

    .navbar-container input[type="checkbox"]:checked ~ .hamburger-lines .line3{
        transform: rotate(-45deg);
    }

}

@media (max-width: 500px){
    .navbar-container input[type="checkbox"]:checked ~ .logo{
        display: none;
    }
}
</style>