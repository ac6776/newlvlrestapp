<template>
  <!-- <messages-list :messages="messages" /> -->
  <messages-list />
</template>

<script>
import { addHandler } from "util/ws";
// import { mapState, mapMutations } from 'vuex'
import { mapMutations } from 'vuex'
import MessagesList from "components/MessagesList.vue";

export default {
  components: {
    MessagesList
  },
  // data: function() {
  //   return {
  //     messages: frontendData,
  //     message: ""
  //   };
  // },
  methods: mapMutations(['addMessageMutation', 'updateMessageMutation', 'removeMessageMutation']),
  created: function() {
    addHandler(data => {
      if (data.objectType === 'MESSAGE') {
        // const index = this.messages.findIndex(item => item.id === data.body.id)
        switch (data.eventType) {
          case 'CREATE':
            this.addMessageMutation(data.body)
            break
          case 'UPDATE':
            this.updateMessageMutation(data.body)
            break
          case 'REMOVE':
            this.removeMessageMutation(data.body)
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