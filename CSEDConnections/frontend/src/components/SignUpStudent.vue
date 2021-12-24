<template>
  <div class="container">

    <div id="app0" class="signup">
    </div>

    <template id="signup-form">

      <form id="signupformStudent">

        <div class="form-group">
          <label for="user">Name</label>
          <input class="rectangle" type="text" v-model="name"  placeholder="Name" maxlength="30" required/>
        </div>

        <div class="form-group">
          <label for="user">Age</label>
          <input class="rectangle" type="text" v-model="age"  placeholder=" 23" maxlength="2" required/>
        </div>

        <div class="form-group">
          <label for="user">Gender</label>
          <section>
          <input type="radio" v-model="gender" value="Male" > Male 
          <a-input-search style='padding-right: 200px'/>
          <input type="radio" v-model="gender" value="Female" > Female
          </section>
        </div>

        <div class="form-group">
          <label for="user">Phone</label>
          <input class="rectangle" type="text" v-model="phone"  placeholder=" Phone" maxlength="11" required/>
        </div>

        <div class="form-group">
          <label for="user">Your Profile Picture URL</label>
          <input class="rectangle" type="text" v-model="profilePicture"  placeholder=" Your Profile Picture URL" maxlength="200" required/>
        </div>     

        <div class="form-group">
          <label for="user">About</label>
          <textarea id="about"  v-model="about" placeholder="Write More About Yourself..."></textarea>
        </div>

        <div class="form-group">
          <label for="user">Current Level</label>
          <section>
          <input type="radio" v-model="level" value="1" > Level 1
          <a-input-search style='padding-right: 50px'/>
          <input type="radio" v-model="level" value="2" > Level 2
          <a-input-search style='padding-right: 75px'/>
          <input type="radio" v-model="level" value="3" > Level 3
          <a-input-search style='padding-right: 50px'/>
          <input type="radio" v-model="level" value="4" > Level 4
          <a-input-search style='padding-right: 50px'/>
          </section>
        </div>    
        <br>
        
        <div class="form-group">
          <label for="user">Expected Graduation Year</label>
          <input class="rectangle" type="text" v-model="expectedgraduationyear"  placeholder=" 2023" maxlength="4" required/>
        </div>   

        <div class="form-group">
          <label for="email">Email</label>
          <input class="rectangle" type="text" v-model="email"  placeholder=" Example@example.com" maxlength="65" required/><span id="goodmessages" v-show="msg4">{{ email1_msg }}</span><span id="badmessages" v-show="msg5">{{ email2_msg }}</span>
        </div>

        <div class="form-group">
          <label for="psw1">Password </label>
          <input class="rectangle" type="password" v-model="pass1word" placeholder=" Password" maxlength="20" required />
        </div>
        
        <div class="form-group">
          <label for="psw2">Confirm Password</label>
          <input class="rectangle" type="password" v-model="pass2word" placeholder=" Confirm Password" maxlength="20" required/>
        </div>
        
        <span id="goodmessages" v-show="msg1">{{ good_msg }}</span><span id="badmessages" v-show="msg2">{{ bad_msg }}</span><span id="badmessages" v-show="msg3">{{ alert_msg }}</span>

        <br><br>

        <div class="form-group">
        <button class="button" @click=signUpAsStudent()>Sign Up</button>
        </div>
        
        <div class="form-group">
        <a href="#1" @click=backSignUpStudent()>Back</a>
        </div>

      </form>

    </template>
  
</div>
</template>

<script>
import axios from 'axios'

export default {
  
  name: 'SignUpStudent',
    data() {
    return {
      information:[],
      
      name: '',
      age: '',
      gender: '',
      phone:'',
      profilePicture:'',
      about:'',

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
        this.$router.push('/');
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
    signUpAsStudent() {
      if(this.msg1 == true && this.msg4 == true) {
      axios.get('http://localhost:8085/api/signUp/student',{
          params: {
              name:this.name, age:this.age,
              gender:this.gender, phone:this.phone, profilePicture:this.profilePicture,
              about:this.about, expectedgraduationyear:this.expectedgraduationyear,
              level: this.level, email:this.email, pass1word:this.pass1word
              }        
          }
      ).then(Response=>{
          const Data = Response.data;
          if(Data !== "Error"){
            this.check = "Congratulations! Sign In Now !"
            setTimeout(this.account, 2000);          
          }
      });
      }
    },
    backSignUpStudent() {
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
