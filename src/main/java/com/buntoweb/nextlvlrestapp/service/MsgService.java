package com.buntoweb.nextlvlrestapp.service;

import com.buntoweb.nextlvlrestapp.entity.Message;
import com.buntoweb.nextlvlrestapp.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MsgService {
    public MessageRepo messageRepo;

    @Autowired
    private void setMessageRepo(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public List<Message> getAllMessages() {
        return (List<Message>) messageRepo.findAll();
    }

    public Message editMsg(Message msg){
        return messageRepo.save(msg);
    }

    public Message addMsg(Message msg){
        msg.setCreationDate(LocalDateTime.now());
        return messageRepo.save(msg);
    }

    public void removeMsg(Long id){
        messageRepo.deleteById(id);
    }
}
