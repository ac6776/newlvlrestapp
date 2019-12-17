<template>
  <div class="input-group mb-3">
    <input type="text" class="form-control" placeholder="write new message here..." v-model="msg" />
    <div class="input-group-append">
      <input type="button" value="save" v-on:click="save" class="btn btn-danger" />
    </div>
  </div>
</template>

<script>

function getId(message, messages) {
    for (let i = 0; i < messages.length; i++) {
        if (messages[i].id === message.id)
        return i;        
    }
    return -1;
}

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
      var message = { id: this.id, msg: this.msg };

      if (this.id) {
        // this.$resource("http://localhost:8080/api/msg{/id}")
        // // this.$resource("/api/msg{/id}")
        //   .update({ id: this.id }, message)
        //   .then(result =>
        //     result.json().then(data => {
        //       console.log(data);
        //       var i = getId(data, this.messages);
        //       this.messages.splice(i, 1, data);
        //     })
        //   );
      } else {
        // this.$resource("http://localhost:8080/api/msg{/id}")
        // // this.$resource("/api/msg{/id}")
        //   .save({}, message)
        //   .then(result =>
        //     result.json().then(data => {
        //       this.messages.push(data);
        //     })
        //   );
      }
      this.msg = "";
      this.id = "";
    }
  }
};
</script>

<style>
</style>