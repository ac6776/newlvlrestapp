
<template>
  <div>
    <input-message :messages="messages" :messageAttr="message" />
    <message-row
      v-for="message in messages"
      v-bind:key="message.id"
      :message="message"
      :messages="messages"
      :editMessage="editMessage"
      :deleteMessage="deleteMessage"
    />
  </div>
</template>

<script>
import InputMessage from "components/InputMessage.vue";
import MessageRow from "components/MessageRow.vue";
import messagesApi from "api/messages";

export default {
  components: {
    InputMessage,
    MessageRow
  },
  props: ["messages"],
  data: function() {
    return {
      message: null
    };
  },
  methods: {
    editMessage: function(message) {
      this.message = message;
    },
    deleteMessage: function(message) {
      messagesApi.remove(message.id).then(result => {
        if (result.ok) {
          console.log(`DELETED: ${message.id}, ${message.msg}`)
        }
      });
    }
  }
};
</script>

<style>
</style>