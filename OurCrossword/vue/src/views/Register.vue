<template>
  <div class="box-form">
    <div class="left">
      <div class="overlay">
        <h1>Create Account</h1>
        <span>
          <p>Enter your registration details to create an account.</p>
        </span>
      </div>
    </div>
    <div class="right">
      <div class="login-container">
        <form @submit.prevent="register">
          <h1>Create Account</h1>
          <div role="alert" v-if="registrationErrors">
            {{ registrationErrorMsg }}
          </div>
          <div class="form-input-group">
            <input type="text" id="username" v-model="user.username" required autofocus placeholder="Enter your Username" />
          </div>
          <div class="form-input-group">
            <input type="password" id="password" v-model="user.password" required placeholder="Enter your Password" />
          </div>
          <div class="form-input-group">
            <input type="password" id="confirmPassword" v-model="user.confirmPassword" required placeholder="Confirm your Password" />
          </div>
          <button type="submit">Create Account</button>
          <p>
            <router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link>
          </p>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
body {
  background-image: linear-gradient(135deg, #FAB2FF 10%, #1904E5 100%);
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
  font-family: "Open Sans", sans-serif;
  color: #333333;
}

.box-form {
  margin: 0 auto;
  width: 80%;
  background: #FFFFFF;
  border-radius: 10px;
  overflow: hidden;
  display: flex;
  flex: 1 1 100%;
  align-items: stretch;
  justify-content: space-between;
  box-shadow: 0 0 20px 6px #090b6f85;
}

@media (max-width: 980px) {
  .box-form {
    flex-flow: wrap;
    text-align: center;
    align-content: center;
    align-items: center;
  }
}

.box-form div {
  height: auto;
}

.box-form .left {
  color: #FFFFFF;
  background-size: 100%;
  background-repeat: no-repeat;
  background-image: url('/pictures/Capture 2 login.PNG');
  overflow: hidden;
}

.box-form .left .overlay {
  padding: 30px;
  width: 100%;
  height: 100%;
  background: #5961f9ad;
  overflow: hidden;
  box-sizing: border-box;
}

.box-form .left .overlay h1 {
  font-size: 10vmax;
  line-height: 1;
  font-weight: 900;
  margin-top: 40px;
  margin-bottom: 20px;
}

.box-form .left .overlay span p {
  margin-top: 30px;
  font-weight: 900;
}

.box-form .left .overlay span a {
  background: #3b5998;
  color: #FFFFFF;
  margin-top: 10px;
  padding: 14px 50px;
  border-radius: 100px;
  display: inline-block;
  box-shadow: 0 3px 6px 1px #042d4657;
}

.box-form .left .overlay span a:last-child {
  background: #1dcaff;
  margin-left: 30px;
}

.box-form .right {
  padding: 40px;
  overflow: hidden;
}

@media (max-width: 980px) {
  .box-form .right {
    width: 100%;
  }
}

.box-form .right h5 {
  font-size: 6vmax;
  line-height: 0;
}

.box-form .right p {
  font-size: 14px;
  color: #B0B3B9;
}

.box-form .right .inputs {
  overflow: hidden;
}

.box-form .right input[type="text"] {
  border: none;
  outline: none;
  border-bottom: 2px solid #B0B3B9;
  margin-top: 25px;
  padding: 10px;
  font-size: 16px;
}

.box-form .right .remember-me--forget-password {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.box-form .right .remember-me--forget-password input {
  margin: 0;
}

.box-form .right #username {
  width: 100%;
  padding: 10px;
  margin-top: 25px;
  font-size: 16px;
  border: none;
  outline: none;
  border-bottom: 2px solid #B0B3B9;
}
.box-form .right #password {
  width: 100%;
  padding: 10px;
  margin-top: 25px;
  font-size: 16px;
  border: none;
  outline: none;
  border-bottom: 2px solid #B0B3B9;
}
.box-form .right input[type="text"] {
  width: 100%;
  padding: 10px;
  margin-top: 25px;
  font-size: 16px;
  border: none;
  outline: none;
  border-bottom: 2px solid #B0B3B9;
  placeholder: "Enter your username";
}

.box-form .right input[type="password"] {
  width: 100%;
  padding: 10px;
  margin-top: 25px;
  font-size: 16px;
  border: none;
  outline: none;
  border-bottom: 2px solid #B0B3B9;
  placeholder: "Enter your password";
}
.box-form .right button[type="submit"] {
  background-color: #3b5998;
  color: #FFFFFF;
  border: none;
  border-radius: 100px;
  padding: 12px 60px;
  font-size: 16px;
  cursor: pointer;
  box-shadow: 0 3px 6px 1px #042d4657;
  margin-top: 25px;
}

.box-form .right button[type="submit"]:hover {
  background-color: #237aec;
}
 </style>