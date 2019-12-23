<template>
  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="write new message here..." v-model="msg" />
    <div class="input-group-append">
      <input type="button" value="save" v-on:click="save" class="btn btn-danger" />
    </div>
  </div>
</template>

<script>
import { sendMessage } from 'util/ws'

export default {
  props: ["messages", "messageAttr"],
  data: function() {
    return {
      id: "",
      msg: ""
    };
  },
  watch: {
    messageAttr: function(newVal, oldVal) {
      this.msg = newVal.msg;
      this.id = newVal.id;
    }
  },
  methods: {
    save: function() {
      sendMessage({id: this.id, msg: this.msg});
      this.msg = "";
      this.id = "";
    }
  }
};
</script>

<style>
</style>