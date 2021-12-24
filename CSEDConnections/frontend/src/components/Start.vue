<template>
  <div class="container">
       <span id="check" >{{check}}</span> 

    <div id="app" class="signup">
    </div>

    <template id="signup-form">

      <form id="registerIdentity">
        <br><br><br>
        <span id="describe">
        The First Website in Faculty of Engineering (Alexandria University) 
        </span>
        <br>
        <span id="describe">
        to conncet Computer and Systems Engineering Department 
        </span>
        <br>
        <span id="describe">
        Students and Graduates
        </span>
        <br><br><br><br>
        <button class="button" @click="registerAsStudent()">Register As a Student</button>
        <button class="button" @click="registerAsGraduate()">Register As a Graduate</button>
        <br><br><br>
        <button class="button" @click="iHaveAccount()">Sign In</button>
      </form>

    </template>
  
</div>
</template>

<script>

export default {
  
  name: 'Start',
    data() {
    return {
    }
  },

  watch: {
  },

  methods: {
    registerAsStudent() {
        this.$router.push('/SignUpStudent');
    },
    registerAsGraduate() {
        this.$router.push('/SignUpGraduate');
    },
    iHaveAccount() {
        this.$router.push('/SignIn');  
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
