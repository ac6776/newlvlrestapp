<template>
  <messages-list :messages="messages" />
</template>

<script>
import { addHandler } from "util/ws";

import { getId } from "util/findIndex";
import MessagesList from "components/MessagesList.vue";

export default {
  components: {
    MessagesList
  },
  data: function() {
    return {
      messages: [],
      message: ""
    };
  },
  created: function() {
    addHandler(data => {
      let index = getId(data, this.messages);
      if (index > -1) {
        this.messages.splice(index, 1, data);
      } else {
        this.messages.push(data);
      }
    });
  }
};
</script>

<style>
</style>