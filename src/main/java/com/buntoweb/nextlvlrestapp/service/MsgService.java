package com.buntoweb.nextlvlrestapp.service;

import com.buntoweb.nextlvlrestapp.entity.Message;
import com.buntoweb.nextlvlrestapp.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgService {
    private MessageRepo messageRepo;

    @Autowired
    private void setMessageRepo(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public List<Message> getAllMessages() {
        return (List<Message>) messageRepo.findAll();
    }


    public Message saveMessage(Message message) {
        if (message.getId() == null) {
            return messageRepo.save(message);
        }
        Message messageFromDb = messageRepo.findById(message.getId()).orElse(null);
        messageFromDb.setMsg(message.getMsg());
        return messageRepo.save(messageFromDb);
    }

    public void removeMsg(Long id){
        messageRepo.deleteById(id);
    }
}
