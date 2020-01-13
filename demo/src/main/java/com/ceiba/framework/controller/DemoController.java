package com.ceiba.framework.controller;

import com.ceiba.application.command.PersonCommand;
import com.ceiba.application.handler.PersonHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("")
public class DemoController{

    @Autowired
    @Qualifier("handler")
    private PersonHandler personHandler;

    public DemoController(PersonHandler personHandler){
        this.personHandler = personHandler;
    }

    @GetMapping(value="/greeting")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "World") String name,Model model) {
        PersonCommand personCommand = new PersonCommand(1,"Daniel Valencia");
        this.personHandler.create(personCommand);
        
        model.addAttribute("name",name);
        return "greeting";
    }
    
}