
<template>
  <div>
    <!-- <input-message :messages="messages" :messageAttr="message" /> -->
    <input-message :messageAttr="message" />
    <message-row
      v-for="message in messages"
      v-bind:key="message.id"
      :message="message"
      :editMessage="editMessage"
    />
    <!-- <message-row
      v-for="message in messages"
      v-bind:key="message.id"
      :message="message"
      :messages="messages"
      :editMessage="editMessage"
      :deleteMessage="deleteMessage"
    />-->
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import InputMessage from "components/InputMessage.vue";
import MessageRow from "components/MessageRow.vue";
// import messagesApi from "api/messages";

export default {
  components: {
    InputMessage,
    MessageRow
  },
  // props: ["messages"],
  data: function() {
    return {
      message: null
    };
  },
  computed: mapGetters(["messages"]),
  methods: {
    editMessage: function(message) {
      this.message = message;
    }
  }
};
</script>

<style>
</style>