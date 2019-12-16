package com.buntoweb.nextlvlrestapp.controller;


import com.buntoweb.nextlvlrestapp.entity.Message;
import com.buntoweb.nextlvlrestapp.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Message> showAllMessages(){
        return msgService.getAllMessages();
    }
}
