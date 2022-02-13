
<template>
  
  <div class="parent">
  
    <div id="graduate">
        <img id="img" :src="graduate.img"/>
        
      
      
    </div>
    <div id="container"> 
   
    <a class="text" >Name{{graduate.name}}</a>
      <br>
      <a class="text">Age:{{graduate.age}}</a>
      <br>
      <a class="text">Email: {{graduate.email}}</a>
      

   </div>
  <div id="costdiv">
    <p class="text">About:</p>
    <p id="p1">{{graduate.about}}</p>
    
  </div>
     
    
   </div>
</template>

<script>
import axios from 'axios'
export default {
  
    name: 'GraduateProfile',
    
 data: () =>{
     return {
        allowfreq:true ,
        msg:'',  
        graduate: {} ,
        
     }
 },
  
 mounted(){
      //when the page loads we call the api 
      //to get products details of the choosen product retrieved from database
      
        axios.post("http://localhost:8081/product/get_graduate_details")
        .then(response =>{ 
            this.graduate = response.data
        });  
        

  },
 methods:{
   
  
    
    
 }
}
</script>

<style>
#img{
   
   
   object-fit: cover;
      object-fit: fill;
    width: 700px;
    height: 500px;
    
}


#img2{
   
   padding-right: 10px;
   object-fit: cover;
      object-fit: fill;
    width: 50px;
    height: 50px;
    cursor: pointer;
}
#a3{
  cursor: pointer;
  font-size: 40px;
  text-decoration: underline

}
#settingmenu{
    cursor: pointer;
}

.parent {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr ;
  grid-template-rows: 1fr;
}

#container{
 
  border:0.5px solid grey;
}
#graduate{
    border:0.5px solid grey;

}
.text{
  font-size: 30px;
    text-decoration: underline
    
}

.p1{
   font-size: 28px;
}
#costdiv{
  border:0.5px solid grey;
}


</style>
