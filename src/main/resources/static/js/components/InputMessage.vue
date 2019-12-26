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
// import messagesApi from "api/messages";
import { mapActions } from "vuex";

export default {
  props: ["messageAttr"],
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
    ...mapActions(["addMessageAction", "updateMessageAction"]),
    save: function() {
      const message = {
        id: this.id,
        msg: this.msg
      };

      if (this.id) {
        this.updateMessageAction(message);
      } else {
        this.addMessageAction(message);
      }
      this.msg = "";
      this.id = "";
    }
    // save: function() {
    //   const message = {
    //     id: this.id,
    //     msg: this.msg
    //   };

    //   if (this.id) {
    //     messagesApi
    //       .update(message)
    //       .then(result => {
    //         if(result.ok) {
    //           console.log(`UPDATED: ${message.id}, ${message.msg}`)
    //         }
    //       }
    //     );
    //   } else {
    //     messagesApi
    //       .add(message)
    //       .then(result =>
    //         result
    //           .json()
    //           .then(data => {
    //             if (result.ok) {
    //               console.log(`CREATED: ${data.id}, ${data.msg}`)
    //             }
    //           })
    //       )
    //   }
    // this.msg = "";
    // this.id = "";
    // }
  }
};
</script>

<style>
</style>