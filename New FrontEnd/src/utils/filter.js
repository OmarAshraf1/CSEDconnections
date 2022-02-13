import Vue from "vue";

Vue.filter("numberFormatter", (value) => {
  if (typeof value !== "number") {
    return value;
  }
  return new Intl.NumberFormat("en-US", { maximumSignificantDigits: 3 }).format(
    value
  );
});

export default Vue.filter;
