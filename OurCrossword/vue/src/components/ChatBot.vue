<template>

  <div id="main" class="main">
    <div id="chat-app">
      <div class="nav">
        <the-header />
      </div>
      <div ref="chatContainer" class="chat-container" id="chatContainer">
        <div id="messages">
          <div v-for="message in messages" v-bind:key="message.id">
            <div class="textbox" v-html="message"></div>
          </div>
        </div>
        <div ref="scrollDiv"></div>
      </div>

      <div class="user-input">
        <form v-if="!firstMessage" v-on:submit.prevent="handleSubmit">
          <input
            class="chat-entry"
            type="text"
            v-model="userMessage"
            placeholder="Type your message here"
          />
          <button>Submit</button>
        </form>

        <form v-if="firstMessage" v-on:submit.prevent="getNickname">
          <input
            class="chat-entry"
            type="text"
            v-model="nickname"
            placeholder="Type your message here"
          />
          <button>Submit</button>
        </form>

        <ul id="commands" class="commands">
          <li>Type "Home" to be returned to the beginning of the chatbot</li>
          <li>Type "Keywords" to see all of the things I can help you with</li>
          <li>Type "Assistance" if you are stuck or unsure what to do</li>
        </ul>
        <p>&#169; Copyright 2023 Tech Elevator</p>
      </div>
    </div>
  </div>
</template>
<script>
// import JobService from '../services/JobService.js';
import QuoteService from "../services/QuoteService.js";
import ResponseService from "../services/ResponseService.js";
import TheHeader from "./TheHeader.vue";
import CatService from "../services/CatService";

export default {
  components: {
    TheHeader,
  },
  data() {
    return {
      userMessage: "",
      botResponseMessage: {},
      messages: [],
      nickname: "",
      firstMessage: true,
      jobHelp: false,
      botStyle:
        '<img class ="ava" src ="https://i.imgur.com/eYEah4e.png" > ChatTErbot:</img><div class = "bot">',
      usertag:
        '<img class ="user-ava" src ="https://pic.onlinewebfonts.com/svg/img_561543.png" />',
      userStyle: '<div class = "user">',
      catPicArray: [],
      title: 'ChatTErbot'
    };
  },

  created() {
    this.messages.push(
      this.botStyle +
        "Hey there, I'm ChatTErbot your cohort companion. What would you like me to call you?"
    );
  },

  mounted() {
    this.scrollToElement();
    document.title = this.title;
  },

  methods: {
    handleSubmit() {
      this.messages.push(
        this.usertag +
          this.nickname +
          " :" +
          this.userStyle +
          this.userMessage +
          "</div>"
      );
      if (
        this.userMessage.toLowerCase().includes("quote") ||
        this.userMessage.toLowerCase().includes("motivation") ||
        this.userMessage.toLowerCase().includes("motivational")
        ||
        this.userMessage.toLowerCase().includes("motivated")
      ) {
        this.isBot = true;
        QuoteService.quote().then((response) => {
          let quote = response.data.quoteText + " -" + response.data.author;
          this.messages.push(this.botStyle + quote + "</div>");
          this.messages.push(
            this.botStyle + " What else can I help you with?" + "</div>"
          );
        });
      } else if (this.userMessage.toLowerCase().includes("assistance")) {
        this.getAssistance();
      } else if (this.userMessage.toLowerCase().includes("bye") || this.userMessage.toLowerCase().includes("goodbye")) {
        window.location.href="https://www.techelevator.com/";
      }else if (this.userMessage.toLowerCase().includes("joke")) {
        this.messages.push(
          this.botStyle +
            "Why do most Java programmers wear glasses? </div>"
        );
        this.messages.push(
          this.botStyle +
            "They can't c#! </div>"
        );
        this.messages.push(
          this.botStyle +
            "Sorry, what else can I help you with? </div>"
        );
      }else if (
        this.userMessage.toLowerCase().includes("thanks") ||
        (this.userMessage.toLowerCase().includes("thank") &&
          this.userMessage.toLowerCase().includes("you"))
      ) {
        this.messages.push(
          this.botStyle +
            "You're welcome! What else can I help you with? </div>"
        );
      } else if (
        this.userMessage.toLowerCase().includes("job search") ||
        this.userMessage.toLowerCase().includes("open positions") ||
        this.userMessage.toLowerCase().includes("jobs") ||
        this.userMessage.toLowerCase().includes("job")
      ) {
        this.messages.push(this.botStyle + "I can help with that! </div>");
        this.messages.push(
          this.botStyle +
            '<a href="http://localhost:8080/jobSearch" target= "_blank">Open Job Search</a></div>'
        );
        this.messages.push(
          this.botStyle + "What else can I help you with? </div>"
        );
      } else if (this.userMessage.toLowerCase().includes("home")) {
        ResponseService.getBotResponse("main", "home").then((response) => {
          let helpMessage = response.data.messageBody;
          this.messages.push(this.botStyle + helpMessage + "</div>");
        });
      } else if (
        this.userMessage.toLowerCase().includes("stress") ||
        this.userMessage.toLowerCase().includes("stressed")
      ) {
        CatService.catPic().then((response) => {
          this.catPicArray = response.data;
          let catPic = this.catPicArray[0];
          this.messages.push(
            this.botStyle +
              '<img class="cat-pic" src="' +
              catPic.url +
              '" alt="cat pic" width="500" height="400"> </div>'
          );
          this.messages.push(
            this.botStyle + "Hope this helps! What else can I help with? </div>"
          );
        });
      } else {
        let messageToSend = {
          messageId: 0,
          messageBody: this.userMessage,
        };
        ResponseService.sendMessage(messageToSend).then((response) => {
          this.responseMessage = response.data.messageBody;
          if (this.responseMessage == null) {
            this.messages.push(
              this.botStyle +
                "Sorry, I'm not sure how to help you, " +
                this.nickname +
                ". Please type your response again or type a command to let me know what I should do. </div>"
            );
          } else {
            this.messages.push(this.botStyle + this.responseMessage + "</div>");
            this.messages.push(
              this.botStyle + " What else can I help you with?" + "</div>"
            );
          }
        });
      }
      this.userMessage = "";
      this.$nextTick(() => {
        this.$refs.chatContainer.scrollTop =
          this.$refs.chatContainer.scrollHeight;
      });
    },

    scrollToElement() {
      const el = this.$refs.scrollToMe;

      if (el) {
        // Use el.scrollIntoView() to instantly scroll to the element
        el.scrollIntoView({ behavior: "smooth" });
      }
    },

    getNickname() {
      let nickname = this.nickname;
      this.messages.push(this.usertag + this.userStyle + nickname + "</div>");
      ResponseService.getFirstResponse().then((response) => {
        this.responseMessage = response.data.messageBody;
        this.messages.push(
          this.botStyle + this.responseMessage + nickname + "? </div>"
        );
      });
      this.$nextTick(() => {
        this.$refs.chatContainer.scrollTop =
          this.$refs.chatContainer.scrollHeight;
      });
      this.firstMessage = false;
    },
    getAssistance() {
      ResponseService.getBotResponse("assistance", "default").then(
        (response) => {
          this.messages.push(
            this.botStyle +
              "Sorry you're stuck, " +
              this.nickname +
              ". " +
              response.data.messageBody +
              "</div>"
          );
        }
      );
    },
  },
};
</script>

<style scoped>
.main {
  font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
  margin: 0;
}

img.cat-pic{
  height:200px;
  width: auto;  
}

.chat-entry {
  padding: 18px;
  font-size: 16px;
  width: 50%;
  border-width: 1px;
  border-color: #cccccc;
  background-color: #ffffff;
  color: #000000;
  border-style: solid;
  border-radius: 10px;
  box-shadow: 0px 0px 5px rgba(66, 66, 66, 0.75);
}

#chat-app {
  height: 100vh;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: auto 1fr auto;
  grid-template-areas:
    "nav"
    "chat-container"
    "user-input";
}

#chat-app > .nav {
  grid-area: nav;
}

#chat-app > .chat-container {
  background: url(https://i.imgur.com/aEr4nSa.png);
  grid-area: chat-container;
  overflow-y: auto;
  max-height: 100%;
  padding: 15px 5px 10px 5px;
}

#chat-app > .user-input {
  grid-area: user-input;
}

.textbox {
  font-size: large;
  overflow-wrap: break-word;
  border-width: 80%;
  margin-top: 20px;
}

.textbox >>> .bot {
  font-family: "Lucida Console", Monaco, monospace;
  background: #eefdff;
  border-width: 3px;
  border-style: solid;
  border-radius: 10px;
  border-color: #80b5ea;
  box-shadow: 0 3px 10px rgb(0 0 0 / 0.2);
  padding: 20px;
  margin-right: 50%;
  margin-left: 50px;
}

.textbox >>> .user {
  background: #ecf9ec;
  overflow-wrap: break-word;
  border-width: 3px;
  border-style: solid;
  border-radius: 10px;
  border-color: #39ac39;
  box-shadow: 0 3px 10px rgb(0 0 0 / 0.2);
  padding: 15px;
  margin-left: 25%;
  margin-right: 25%;
}

.textbox >>> .ava {
  width: 30px;
  height: 30px;
  font-size: small;
  text-align: center;
  vertical-align: middle;
  padding: 5px;
  margin-left: 50px;
}

.textbox >>> img.user-ava {
  width: 30px;
  height: 30px;
  font-size: small;
  text-align: center;
  vertical-align: middle;
  padding: 5px;
  margin-left: 25%;
  margin-right: 5px;
}

button {
  box-shadow: 0px 10px 14px -7px #a8a8a8;
  background: linear-gradient(to bottom, #bddbfa 5%, #80b5ea 100%);
  background-color: #bddbfa;
  border-radius: 8px;
  display: inline-block;
  cursor: pointer;
  color: #000000;
  font-size: 15px;
  font-weight: bold;
  padding: 10px 15px;
  margin: 20px;
  text-decoration: none;
}
button:hover {
  background: linear-gradient(to bottom, #80b5ea 5%, #bddbfa 100%);
  background-color: #80b5ea;
}
button:active {
  position: relative;
  top: 1px;
}

ul {
  list-style: none;
  margin-top: 5px;
  padding: 0;
}

li {
  font-size: 12px;
  line-height: 1.5;
  margin-bottom: 3px;
}

@media (max-width: 480px) {
  .textbox >>> .bot {
    padding: 10px;
    margin-right: 30px;
    margin-left: 2%;
  }

  .textbox >>> .ava {
    width: 20px;
    height: 20px;
    font-size: small;
    text-align: center;
    vertical-align: middle;
    padding: 5px;
    margin-left: 2%;
  }

  .textbox >>> .user {
    padding: 10px;
    margin-left: 25%;
    margin-right: 2%;
  }
}
</style>
