import Vue from "vue";
import Vuetify from "vuetify/lib/framework";

Vue.use(Vuetify);

export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: "hsl(0, 0%, 100%)",
        background: "hsl(0, 0%, 98%)",
        input: "hsl(0, 0%, 52%)",
        text: "hsl(200, 15%, 8%)",
      },
      dark: {
        primary: "hsl(209, 23%, 22%)",
        background: "hsl(207, 26%, 17%)",
        text: "hsl(0, 0%, 100%)",
        input: "hsl(0, 0%, 52%)",
      },
    },
  },
});
