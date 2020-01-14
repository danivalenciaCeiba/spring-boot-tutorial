package com.ceiba.framework.controller;

import com.ceiba.domain.entity.Person;
import com.ceiba.domain.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value="/greeting")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "World") String name,Model model) {        
        Person person = new Person();
        person.setId(1);
        person.setName("Daniel Mauricio");
        personRepository.save(person);
        
        model.addAttribute("name",name);
        return "greeting";
    }
}