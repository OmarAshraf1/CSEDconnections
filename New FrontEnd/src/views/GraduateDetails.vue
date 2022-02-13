<template>
  <v-container>
    <v-row
      ><v-col
        ><v-btn class="btn" @click="goBack"
          ><v-icon>mdi-arrow-left</v-icon> Back</v-btn
        ></v-col
      ></v-row
    >
    <v-row>
      <v-col md="6" sm="12" xs="12">
        <v-img :src="graduate.img"></v-img>
      </v-col>
      <v-col md="6" sm="12" xs="12" class="pa-2">
        <div class="mt-8">
          <h2>{{ graduate.name }}</h2>
          <v-row class="mt-3">
            <v-col lg="12" md="12" sm="12" xs="12">
              <div
                :class="`d-flex justify-space-between flex-wrap `"
                style="height: 100%">
                <div>
                  <div>
                    <b>Graduation Year: </b
                    >{{ graduate.graduationYear ? graduate.graduationYear : "NA" }}
                  </div>
                  <div>
                    <b>Company: </b
                    >{{experience[0].companyName }}
                  </div>
                  <div><b>Location: </b>{{ experience[0].location }}</div>
                  <div><b>Position: </b>{{ experience[0].position }}</div>
                  <div><b>Contact: </b>{{ graduate.mail }}</div>
                  <div><b>Phone: </b>{{ graduate.phone }}</div>
                  <div><b>about: </b>{{ graduate.about }}</div>
                  <a :href= "social.facebook"  target="_blank" >
        <img class="facebook0" alt="facebook" src="https://annashra.org/wp-content/uploads/2018/10/logo-facebook.png">
     </a>
     <a :href= "social.linkedin"  target="_blank" >
        <img class="facebook0" alt="linkedin" src="https://denkavit.com/en/wp-content/uploads/sites/8/2021/11/LinkedIn-logo.png">
     </a>
                  
                </div>
                <!--div>
                  <div>
                    <b>Top Level Domain: </b
                    ><span
                      class="mr-2"
                      v-for="domain in country.topLevelDomain"
                      :key="domain"
                      >{{ domain }}</span
                    >
                  </div>
                  <div>
                    <b>Currencies: </b
                    ><span
                      class="mr-2"
                      v-for="currency in country.currencies"
                      :key="currency.code"
                      >{{ country.name }}</span
                    >
                  </div>
                  <div>
                    <b>Languages: </b
                    ><span
                      class="mr-2"
                      v-for="language in country.languages"
                      :key="language.name"
                      >{{ language.name }}
                    </span>
                  </div>
                </div-->
              </div>
            </v-col>
          </v-row>
          <!--div class="mt-2">
            Border Countries:
            <span>
              <v-btn
                class="mr-2 mb-2"
                v-for="border in country.borders"
                @click="getBorder(border)"
                :key="border"
                >{{ border }}</v-btn
              >
            </span>
          </div-->
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      graduate: {},
      social: {},
      graduateEmail: "",
      experience: [],
    };
  },
  mounted() {
    
    this.init();
  },

  methods: {
    init() {
      if (this.$route.params.code) {
        let data = atob(this.$route.params.code);
        this.graduateEmail = data;
        this.getGraduateDetail();
        this.getsocial() ;
      }  
    },
    getGraduateDetail() {
      axios.get('http://localhost:8085/getGraduate',{
            params: {
              email:this.graduateEmail
            }
        }).then(Response=>{
            this.graduate= Response.data;
            this.experience=this.graduate.experience;
        });
    },
      getsocial() {
      axios.get('http://localhost:8085/getsocial',{
            params: {
              email:this.graduateEmail
            }
        }).then(Response=>{
            this.social= Response.data;
            
        });
    },
    goBack() {
      this.$router.push({
        name: "Home",
      });
    }
  },
};
</script>

<style>
.facebook0 {
height: 50px;
width:50px;
}
</style>