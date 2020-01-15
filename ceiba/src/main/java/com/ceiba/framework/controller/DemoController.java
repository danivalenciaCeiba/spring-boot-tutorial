package com.ceiba.framework.controller;

import com.ceiba.application.command.PersonCommand;
import com.ceiba.application.handler.PersonHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
    
    private PersonHandler personHandler;    
    private PersonCommand personCommand;

    public DemoController(PersonHandler personHandler,PersonCommand personCommand){
        this.personHandler = personHandler;
        this.personCommand = personCommand;
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "World") String name,Model model) {        
        this.personCommand.setId(1);
        this.personCommand.setName("Daniel Mauricio Valencia");
        this.personHandler.create(this.personCommand);
        
        model.addAttribute("name",name);
        return "greeting";
    }

    @GetMapping("/list")
    public String  list(Model model){
        model.addAttribute("people", this.personHandler.list());
        return "greeting";
    }
}