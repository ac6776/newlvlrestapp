<template>
  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="write new message here..." v-model="msg" />
    <div class="input-group-append">
      <input type="button" value="save" v-on:click="save" class="btn btn-danger" />
    </div>
  </div>
</template>

<script>
// import { sendMessage } from 'util/ws'
import messagesApi from "api/messages";

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
      // sendMessage({id: this.id, msg: this.msg});
      const message = {
        id: this.id,
        msg: this.msg
      };

      if (this.id) {
        messagesApi
          .update(message)
          .then(result =>
            result
              .json()
              .then(data =>
                this.messages.splice(this.messages.indexOf(data), 1, data) //edit to findIndex(item => item.id === data.id)
              )
          );
      } else {
        messagesApi
          .add(message)
          .then(result => result.json().then(data => this.messages.push(data)));
      }
      this.msg = "";
      this.id = "";
    }
  }
};
</script>

<style>
</style>