<template>
    <messages-list :messages="messages"/>
</template>

<script>
    import MessagesList from 'components/MessagesList.vue';

    export default {
        components: {
            MessagesList
        },
        data: function() {
            return {
                messages: [],
                message: ''
            }
        }
    }
</script>

<style>

</style>