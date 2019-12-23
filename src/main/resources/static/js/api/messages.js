import Vue from 'vue'

const messages = Vue.resource('api/msg{/id}')

export default {
    add: message => messages.save({}, message),
    update: message => messages.update({id: message.id}, message),
    remove: id => messages.remove({id})
}