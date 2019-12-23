package com.buntoweb.nextlvlrestapp.controller;


import com.buntoweb.nextlvlrestapp.dto.EventType;
import com.buntoweb.nextlvlrestapp.dto.ObjectType;
import com.buntoweb.nextlvlrestapp.entity.Message;
import com.buntoweb.nextlvlrestapp.entity.Views;
import com.buntoweb.nextlvlrestapp.service.MsgService;
import com.buntoweb.nextlvlrestapp.util.WsSender;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.BiConsumer;

@RestController
@RequestMapping("/api")
public class MessageRestController {
    private MsgService msgService;
    private BiConsumer<EventType, Message> wsSender;

//    @Autowired
//    public void setMsgService(MsgService msgService) {
//        this.msgService = msgService;
//    }
    @Autowired
    public MessageRestController(MsgService msgService, WsSender wsSender) {
        this.msgService = msgService;
        this.wsSender = wsSender.getSender(ObjectType.MESSAGE, Views.IdMsg.class);
    }

    @GetMapping("/msg")
    @JsonView(Views.IdMsg.class)
    public List<Message> showAllMessages(){
        return msgService.getAllMessages();
    }

    @PutMapping("/msg/{id}")
    public Message editMessage(@PathVariable int id, @RequestBody Message msg){
        Message updatedMessage = msgService.saveMessage(msg);
        wsSender.accept(EventType.UPDATE, updatedMessage);
        return updatedMessage;
    }

    @PostMapping("/msg")
    public Message addMessage(@RequestBody Message msg){
        Message createdMessage = msgService.saveMessage(msg);
        wsSender.accept(EventType.CREATE, createdMessage);
        return createdMessage;
    }

    @DeleteMapping("/msg/{id}")
    public void deleteMessage(@PathVariable Long id) {
        msgService.removeMsg(id);
        wsSender.accept(EventType.REMOVE, message);
    }

//    @MessageMapping("/changeMessage")
//    @SendTo("/topic/activity")
//    public Message changeMessage(Message message) {
//        return msgService.saveMessage(message);
//    }
}
