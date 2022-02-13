<template>
      <v-container >
        <div class="yoyo">
        <h2>Your Announcement</h2>
        </div>
        <br>
        <div class="yoyo">
        <textarea id="txt" v-model="post" placeholder="Your Post"></textarea>
        </div>
        <br>
         <v-btn class="p1" @click=goToAnnoucement()>Back</v-btn>
         <v-btn class="p2"  @click=Post()>Post Announcement</v-btn>

        </v-container>
</template>

<script>
import axios from 'axios';
export default {
  name: "App",
  
  data() {
    return {      
      post: '',
      name: '',
      email: '',
    }
  },
  methods: {
      Post(){
          axios.get('http://localhost:8085/post',{
            params: {
              post:this.post,
              name:this.name,
              email:this.email
            }
        })
        this.$router.push({
        name: "Announcements",
      });
      },
          goToAnnoucement() {
      this.$router.push({
        name: "Announcements",
      });
    },
  }
};

</script>
<style>

#txt{
  width: 50%;
  height: 200px;
  padding: 12px 20px;
  box-sizing: border-box;
  border: 2px solid #ccc;
  border-radius: 4px;
  background-color: #f8f8f8;
  font-size: 16px;
  resize: none;
-moz-box-align: center;  

}

.yoyo{
      display: flex;
    justify-content: center;
    flex-wrap: wrap;

}

.p1{
  margin-left: 290px;

}
.p2{
  margin-left: 300px;
}
</style>
