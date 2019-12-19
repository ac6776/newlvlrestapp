package com.buntoweb.nextlvlrestapp.controller;


import com.buntoweb.nextlvlrestapp.entity.Message;
import com.buntoweb.nextlvlrestapp.entity.Views;
import com.buntoweb.nextlvlrestapp.service.MsgService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageRestController {
    private MsgService msgService;

    @Autowired
    public void setMsgService(MsgService msgService) {
        this.msgService = msgService;
    }

    @GetMapping("/msg")
    @JsonView(Views.IdMsg.class)
    public List<Message> showAllMessages(){
        return msgService.getAllMessages();
    }

    @PutMapping("/msg/{id}")
    public Message editMessage(@PathVariable int id, @RequestBody Message msg){
        return msgService.saveMessage(msg);
    }

    @PostMapping("/msg")
    public Message addMessage(@RequestBody Message msg){
        return msgService.saveMessage(msg);
    }

    @DeleteMapping("/msg/{id}")
    public void deleteMessage(@PathVariable Long id) {
        msgService.removeMsg(id);
    }

    @MessageMapping("/changeMessage")
    @SendTo("/topic/activity")
    public Message changeMessage(Message message) {
        return msgService.saveMessage(message);
    }
}
