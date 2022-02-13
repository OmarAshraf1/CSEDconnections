<template>
  <div class="container">
       <span id="check" >{{check}}</span> 

    <div id="app" class="signup">
    </div>

    <template id="signup-form">

      <form id="signinform">

        <div class="form-group">
          <label for="email">Email</label>
          <input class="rectangle" type="text" v-model="email" placeholder="Example@example.com" maxlength="65" required/><span id="goodmessages" v-show="msg4">{{ email1_msg }}</span><span id="badmessages" v-show="msg5">{{ email2_msg }}</span>
        </div>

        <div class="form-group">
          <label for="psw1">Password </label>
          <input class="rectangle" type="password" v-model="pass1word" placeholder="Password" maxlength="20" required />
        </div>

        <br><br>

        <div class="form-group">
          <button class="button" @click=signIn()>Sign In</button>
        </div>

        <div class="form-group">
        <a href="#1" @click=backSignIn()>Back </a>
        </div>

      </form>

    </template>
  
</div>
</template>

<script>
import axios from 'axios'

export default {
  
  name: 'SignIn',
    data() {
    return {      
      firstname: '',
      lastname: '',
      age: '',
      gender: '',
      phone:'',
      profilePicture:'',
      about:'',

      graduationyear:'',
      position: '',
      company: '',
      location: '',
      
      level: '',
      expectedgraduationyear: '',

      email: '',
      pass1word: '',
      pass2word: '',
      email1_msg: '',
      email2_msg: '',
      good_msg: '',
      bad_msg: '',
      alert_msg: '',

      msg1: false,
      msg2: false,
      msg3: false,
      msg4: false,
      msg5: false,
      
      check:"",
    }
  },

  watch: {
    email: function(value) {
      this.emailCheck(value);
      if(value == "") {
        this.check = "";
        this.msg5 = false;
      }
    },
    pass1word: function(value) {
      this.check_password_length(value);
      this.check_passwords_match();
    },
    pass2word: function() {
      this.check_passwords_match();
    }
  },

  methods: {
    account() {
         this.$router.push('/DisplayGraduates');
    },
    emailCheck(value) {
      if (/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(value)) {
        this.msg4 = true;
        this.msg5 = false;
        this.email1_msg = '';
        this.email2_msg = '';
      }
      else {
        this.msg4 = false;
        this.msg5 = true;
        this.email1_msg = '';
        this.email2_msg = 'Invalid Email (example@example.example)';
      }
    },
    check_password_length(value) {
      var n= value.length;
      if (n < 6 && n > 0) {
        this.msg3 = true;
        this.alert_msg = 'Alert: Six Characters At Least';
      }
      else {
        this.msg3 = false;
        this.alert_msg = '';
      }
    },
    check_passwords_match() {
      if(this.pass1word == '' || this.pass2word == ''){
        this.msg1 = false;
        this.msg2 = false;
        this.good_msg = '';
        this.bad_msg = '';
      }
      else {
          if(this.pass2word != this.pass1word) {
            this.bad_msg = 'Passwords do not match \t\t\t';
            this.msg1 = false;
            this.msg2 = true;
            return true;
          } else {
            this.good_msg = 'Passwords Match';
            this.msg1 = true;
            this.msg2 = false;
            return false;
          }
      }
    },
    signIn(){
      if(this.msg4 == true ) {
            axios.get('http://localhost:8085/api/signinGrad',{
                params: {
                    email:this.email,
                    pass1word:this.pass1word
                }
            }).then(Response=>{
                const Data = Response.data;
                if(Data == "Successfully Logged In"){
                  this.check = Data ;
                  setTimeout(this.account, 2000);
                }else {
                  this.check=Data;
                }
            });
      }
    },
    backSignIn() {
        this.$router.push('/');
    },

  },
}
</script>

<style>

body {
  height: 100%;
  font-family: 'Roboto', sans-serif;
  background: linear-gradient(to right, #02021f, #252135);
  
}

.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  
}

.signup {
  width: 6.4in;
  height: 2.8in;
  position: relative;
  overflow: hidden;
  box-shadow: 10px 10px 60px rgba(0, 0, 0, 0.322);
  display: flex;
  justify-content: flex-end;
  align-items: center;
  border-radius: 5px;
  background-image: url("../assets/b.png") ;

}

form {
  width: 50%;
  height: 70%;
  padding: 20px 50px 20px 20px;
  
}

form .form-group {
  display: flex;
  flex-direction: column;
  margin: 0 0 20px 0;
  color: #ffffff;
  font-size: 0.5cm;
}
form .form-group label {
  margin: 0 0 16px 0;
}

.form-group input[type="text"],
.form-group input[type="password"] {
  border:  1px inset #ffffff;
  border-radius: 5px;
  background: transparent;
  padding: 0px 5px;
  font-size: 1em;
  color: #ffffff;
}
.button {
  background-color: #3c3fcf; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.button:hover { 
  background-color: #405feb; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button:active {
  background-color:rgb(6, 167, 0);
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.rectangle {
  height: 1cm;
}
#goodmessages {
  font-size: 0.4cm;
  color: rgb(0, 255, 76);
}
#badmessages {
  font-size: 0.4cm;
  color: rgb(255, 0, 0);
}
#check {
  font-size: 0.7cm;
  color: rgb(231, 231, 231);
}
#describe {
  color: #ffffff;
}

</style>
