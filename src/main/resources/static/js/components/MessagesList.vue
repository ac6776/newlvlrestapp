
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
import messagesApi from 'api/messages'

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
  created: function() {
    messagesApi
      .get()
      .then(result =>
        result
          .json()
          .then(data => data.forEach(message => this.messages.push(message)))
      );
  },
  methods: {
    editMessage: function(message) {
      this.message = message;
    },
    deleteMessage: function(message) {
      this.message = message;
      messagesApi
        .remove({ id: this.message.id })
        .then(result => {
          if (result.ok) {
            this.messages.splice(this.messages.indexOf(this.message), 1); //edit to findIndex(item => item.id === data.id)
          }
        });
    }
  }
};
</script>

<style>
</style>