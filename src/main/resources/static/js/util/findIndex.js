export function getId(message, messages) {
    for (let i = 0; i < messages.length; i++) {
      if (messages[i].id === message.id) return i;
    }
    return -1;
  }