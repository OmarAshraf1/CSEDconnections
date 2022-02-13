<template>
 <div id="container"> 
   
     <h1 >Graduates</h1> 
     
    <div class="category">
    <div id="categorycontainer" v-for="graduate in graduates" :key="graduate.name">
      <img id="img" :src="graduate.img"/>
      <br>
       <a id="a2"  >{{graduate.name}}</a>
        <br>
        <a id="a1">{{graduate.email}}</a>
        <br>
        <a id="a1">{{graduate.company}}</a>
        <br>
        <a id="a1">{{graduate.location}}</a>
        
    </div>  
    </div>
  </div>
</template>

<script>
  import axios from 'axios'
export default {
   data() {
    return {
     graduates:[],
     name: '',
      
    }
  },
  methods: {  
    
  },
 
  mounted(){
      //when the page loads we call the api 
      //to get graduates data retrieved from database
      
<<<<<<< Updated upstream
        axios.post('http://localhost:8085/get_graduates',{
              
            })
            .then(Response =>  {
              for (var i = 0; i < Response.data.length; i++){
                var obj = Response.data[i]
                this.graduates.push(obj)
              }
            
            
          });
=======
        axios.post("http://localhost:8085/get_graduates")
        .then(response =>{ 
          
         if(response.data.length>0){
           /*
              for (var i = 0; i < response.data.length; i++){
                  var obj = response.data[i]
                  this.graduates.push(obj)
                } 
             */   
         }
        });  
>>>>>>> Stashed changes
  }
}
</script>

<style>
#a1{
  text-decoration: underline;
  cursor: pointer;
}
#img{
    object-fit: cover;
    object-fit: fill;
    cursor: pointer;
    height: 275px;
    width: 250px;
   
}
#categorycontainer{
    border: 1.7px;
    border-style: solid;
}
.category{
    display: grid;
  
    grid-column-gap: 10px;
    grid-row-gap: 10px;
    grid-template-columns: 1fr 1fr 1fr;
   
}
<<<<<<< Updated upstream
#container{
   
}
=======

>>>>>>> Stashed changes
#a2{
    font-size: 30px; 
    color:rgb(0, 82, 163);
    cursor: pointer;   
}
#a1{
    font-size: 22px; 
    color: rgba(227, 236, 248, 0.404) ;
      
}
#h1{
    padding-right: 1400px;
}
#img2{
   
   padding-right: 1300px;
   object-fit: cover;
      object-fit: fill;
    width: 50px;
    height: 50px;
    cursor: pointer;
}
.input{
    width: 35%;
    height: 25px;
    border:2px solid rgb(50, 73, 117);
    border-radius: 6px;

}

</style>
