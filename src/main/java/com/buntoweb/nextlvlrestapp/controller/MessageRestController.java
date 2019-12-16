package com.buntoweb.nextlvlrestapp.controller;


import com.buntoweb.nextlvlrestapp.entity.Message;
import com.buntoweb.nextlvlrestapp.entity.Views;
import com.buntoweb.nextlvlrestapp.service.MsgService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
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
        return msgService.editMsg(msg);
    }

    @PostMapping("/msg")
    public Message addMessage(@RequestBody Message msg){
        return msgService.addMsg(msg);
    }

    @DeleteMapping("/msg/{id}")
    public void deleteMessage(@PathVariable Long id) {
        msgService.removeMsg(id);
    }
}
