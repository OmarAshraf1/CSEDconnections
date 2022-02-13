<template>
  <v-app>
    <nav-bar></nav-bar>
    <v-main>
      
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import NavBar from "./components/NavBar.vue";
export default {
  name: "App",
  components: {
    "nav-bar": NavBar,
  },
  data: () => ({
    //
  }),
};
</script>
<style>
@import "./assets/style.css";
</style>
