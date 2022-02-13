
<template>
  
  <div class="parent">
  
    <div id="grad">
        <img id="img" :src="graduate.img"/>
        
      
      
    </div>
    <div id="container"> 
   
    <a class="p1" >{{graduate.name}}</a>
      <br>
      <a class="p1">{{graduate.mail}}</a>
      <br>
      <a class="p1">Name: {{graduate.age}}</a>
      
      
   </div>
  <div id="costdiv">
     <p class="text">About :</p>
      
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
       
      
         graduate: {} ,
       
     }
 },
  
 mounted(){
      //when the page loads we call the api 
      //to get graduates details of the choosen graduates retrieved from database
      
        axios.post('http://localhost:8085/get_graduate_details',{
              
            })
            .then(Response =>  {
              this.graduate = Response.data           
            
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
#imgfreq{
  object-fit: cover;
      object-fit: fill;
     width: 100px;
    height: 100px;
    cursor: pointer;
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
#freq{
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr;
}
#container{
 
  border:0.5px solid grey;
}
#product{
    border:0.5px solid grey;

}
.text{
  font-size: 30px;
    text-decoration: underline
    
}
#cartbutton{
   color: rgb(226, 223, 223);
  
  text-align: center;
    background-color: rgb(22, 73, 133);
  display: inline-block;
  font-size: 40px;
  border-radius: 25px;
  cursor: pointer;
  width: 260px;
}
.p1{
   font-size: 28px;
}
#costdiv{
  border:0.5px solid grey;
}
#freq{
  border:0.5px solid grey;
}
#afreq{
      text-decoration: underline;
      cursor: pointer;
}

</style>
