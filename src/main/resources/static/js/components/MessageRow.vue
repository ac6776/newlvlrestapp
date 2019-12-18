<template>
  <div class="message">
    <div>{{ message.id }} {{ message.msg }}</div>
    <button class="btn btn-primary button" type="button" v-on:click="edit">
      <i class="fas fa-pen"></i>
    </button>
    <button class="btn btn-primary button" type="button" v-on:click="del">
      <i class="fas fa-times"></i>
    </button>
  </div>
</template>
<script>
export default {
  props: ["message", "messages", "deleteMessage", "editMessage"],
  methods: {
    edit: function() {
      this.editMessage(this.message);
    },
    del: function() {
      this.deleteMessage(this.message);
      this.message.msg = "";
      this.message.id = "";
    }
  }
};
</script>
<style>
</style>