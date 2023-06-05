<template>
  <div>
    <h1>Welcome back!</h1>
    <span>
      <p>Enter your login details to access your account.</p>
    </span>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",

  data() {
    return {
      user: {
        username: "",
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
body {
  background-image: linear-gradient(135deg, #fab2ff 10%, #1904e5 100%);
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
  font-family: "Open Sans", sans-serif;
  color: #333333;
}

.box-form {
  padding-top: 40px;
  margin: 0 auto;
  width: 80%;
  background: #ffffff;
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
  color: #ffffff;
  background-size: 100%;
  background-repeat: no-repeat;

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
  font-size: 8vmax;
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
  color: #ffffff;
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
  color: #b0b3b9;
}

.box-form .right .inputs {
  overflow: hidden;
}

.box-form .right input[type="text"] {
  border: none;
  outline: none;
  border-bottom: 2px solid #b0b3b9;
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
  border-bottom: 2px solid #b0b3b9;
}
.box-form .right #password {
  width: 100%;
  padding: 10px;
  margin-top: 25px;
  font-size: 16px;
  border: none;
  outline: none;
  border-bottom: 2px solid #b0b3b9;
}
.box-form .right input[type="text"] {
  width: 100%;
  padding: 10px;
  margin-top: 25px;
  font-size: 16px;
  border: none;
  outline: none;
  border-bottom: 2px solid #b0b3b9;
  placeholder: "Enter your username";
}

.box-form .right input[type="password"] {
  width: 100%;
  padding: 10px;
  margin-top: 25px;
  font-size: 16px;
  border: none;
  outline: none;
  border-bottom: 2px solid #b0b3b9;
  placeholder: "Enter your password";
}
.box-form .right button[type="submit"] {
  background-color: #3b5998;
  color: #ffffff;
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