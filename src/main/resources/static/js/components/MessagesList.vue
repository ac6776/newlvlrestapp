
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

function getId(message, messages) {
  for (let i = 0; i < messages.length; i++) {
    if (messages[i].id === message.id) return i;
  }
  return -1;
}

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
    this.$resource("http://localhost:8080/api/msg{/id}")
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
      this.$resource("http://localhost:8080/api/msg{/id}")
        // this.$resource("/api/msg{/id}")
        .remove({ id: this.message.id })
        .then(result => {
          if (result.ok) {
            this.messages.splice(getId(this.message, this.messages), 1);
          }
        });
    }
  }
};
</script>

<style>
</style>