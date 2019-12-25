<template>
  <messages-list :messages="messages" />
</template>

<script>
import { addHandler } from "util/ws";

// import { getId } from "util/findIndex";
import MessagesList from "components/MessagesList.vue";

export default {
  components: {
    MessagesList
  },
  data: function() {
    return {
      messages: frontendData,
      message: ""
    };
  },
  created: function() {
    addHandler(data => {
      if (data.objectType === 'MESSAGE') {
        const index = this.messages.findIndex(item => item.id === data.body.id)
        switch (data.eventType) {
          case 'CREATE':
          case 'UPDATE':
            if (index > -1){
              this.messages.splice(index, 1, data.body)
            } else {
              this.messages.push(data.body)
            }
            break
          case 'REMOVE':
            this.messages.splice(index, 1)
            break
          default:
            console.error(`EventType is unknown: "${data.eventType}"`)
        }
      } else {
          console.error(`ObjectType is unknown: "${data.objectType}"`)
      }
    });
  }
};
</script>

<style>
</style>