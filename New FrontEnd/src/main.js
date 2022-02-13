import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import "./utils/filter";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faMoon, faSun } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import vuetify from "./plugins/vuetify";

Vue.config.productionTip = false;

library.add(faMoon);
library.add(faSun);
Vue.component("font-awesome-icon", FontAwesomeIcon);

new Vue({
  router,
  vuetify,
  render: (h) => h(App),
}).$mount("#app");

