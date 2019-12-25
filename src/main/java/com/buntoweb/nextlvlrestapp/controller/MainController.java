package com.buntoweb.nextlvlrestapp.controller;

import com.buntoweb.nextlvlrestapp.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final MsgService msgService;

    @Autowired
    public MainController(MsgService msgService) {
        this.msgService = msgService;
    }

    @GetMapping ("/")
    public String showHome(Model model) {
        model.addAttribute("frontendData", msgService.getAllMessages());
        return "index";
    }
}
