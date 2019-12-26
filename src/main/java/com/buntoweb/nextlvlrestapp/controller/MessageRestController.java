package com.buntoweb.nextlvlrestapp.controller;


import com.buntoweb.nextlvlrestapp.dto.EventType;
import com.buntoweb.nextlvlrestapp.dto.ObjectType;
import com.buntoweb.nextlvlrestapp.entity.Message;
import com.buntoweb.nextlvlrestapp.entity.Views;
import com.buntoweb.nextlvlrestapp.service.MsgService;
import com.buntoweb.nextlvlrestapp.util.WsSender;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/msg")
    @JsonView(Views.IdMsg.class)
    public Message addMessage(@RequestBody Message msg){
        Message createdMessage = msgService.saveMessage(msg);
        wsSender.accept(EventType.CREATE, createdMessage);
        return createdMessage;
    }

    @PutMapping("/msg/{id}")
    @JsonView(Views.IdMsg.class)
    public Message editMessage(@PathVariable int id, @RequestBody Message msg){
        Message updatedMessage = msgService.saveMessage(msg);
        wsSender.accept(EventType.UPDATE, updatedMessage);
        return updatedMessage;
    }

    @DeleteMapping("/msg/{id}")
    public void deleteMessage(@PathVariable("id") Message message) {
        msgService.removeMsg(message);
        wsSender.accept(EventType.REMOVE, message);
    }

//    @MessageMapping("/changeMessage")
//    @SendTo("/topic/activity")
//    public Message changeMessage(Message message) {
//        return msgService.saveMessage(message);
//    }
}
