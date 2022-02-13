<template>
  <v-card >
    <v-card-text>
      <div class="card_title" @click="gotoDetails">{{ name }}</div>
      <div><b>Post: </b>{{ post }}</div>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  props: {
    name: { type: String, default: "NA" },
    post: { type: String, default: "NA" },
    email: { type: String, default: "NA" }

},
  
  methods: {

    gotoDetails() {
      this.$router.push({
        name: "Details",
        params: { code: btoa(this.email) },
      });
    },
    
  },
};
</script>

<style>
.card_title {
  font-weight: bold;
  font-size: 16px;
  margin-bottom: 10px;
}
.card img {
  width: 100%;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  object-fit: cover;
  object-position: 50% 100%;
}
</style>