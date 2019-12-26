import Vue from "vue";
import 'api/resource';
// import "core-js/stable";
// import "regenerator-runtime/runtime";
import '@babel/polyfill'
import App from "pages/App.vue";
import store from 'store/store'
import { connect } from 'util/ws';

connect();

new Vue({
  el: "#app",
  store,
  render: a => a(App)
});
