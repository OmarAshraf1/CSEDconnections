<template>
  <v-container>
      <v-col>
        <v-div>
        <v-btn large outlined rounded  @click="goToHome"> Home </v-btn> <v-btn large outlined rounded> Announcements </v-btn> <v-btn @click="goToCreatePost" class="createbtn" large outlined> Create Post </v-btn> <br><br>
        </v-div>
        <v-text-field
          label="Search"
          v-model="search"
          solo
          prepend-inner-icon="mdi-magnify"
          clearable
          @click:clear="clearSearch"
        >
        </v-text-field
      >

    </v-col>
      <v-spacer class="d-none d-md-flex d-lg-flex"></v-spacer>
      <v-col> 
      </v-col>
    <v-row>
      <v-col v-for="post in posts" :key="post.email" md="6">
        <post-card v-bind="post"></post-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import PostCard from "../components/PostCard.vue";
import axios from 'axios';

export default {
  name: "Home",
  components: {
    "post-card": PostCard,
  },
  data() {
    return {
      posts:[],
      name: '',
      search: "",
      
    };
  },
  mounted() {
    this.getPosts();
  },

  watch: {
    
    search: {
      immediate: true,
      handler(val) {
        if (val) {
          this.Company = null; 
        }
        this.getPosts();
      },
    },
    
  },
  methods: {
  
    CompanyChange() {
      this.search = "";
      this.getPosts();
    },
    clearSearch() {
      setTimeout(() => {
        this.search = "";
        this.getPosts();
      }, 10);
    },
    goToHome() {
      this.$router.push({
        name: "Home",
      });
    },    
    goToCreatePost() {
      this.$router.push({
        name: 'PostAnouncement',
      });
    },
    getPosts() {
      //when the page loads we call the api 
      //to get posts data retrieved from database
      
      axios.get('http://localhost:8085/getPosts',{
            params: {
              Search:this.search
            }
        })
          .then(Response =>  {
            this.posts.length=0;
            for (var i = 0; i < Response.data.length; i++){
              var obj = Response.data[i]
              this.posts.push(obj)
            }
        });
    },
  },
};
</script>
<style>
.createbtn {
    margin-left:715px;
    }
</style>
