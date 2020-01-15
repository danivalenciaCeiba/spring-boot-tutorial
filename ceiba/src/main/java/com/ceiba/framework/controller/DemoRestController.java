package com.ceiba.framework.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.ceiba.application.command.PersonCommand;
import com.ceiba.application.handler.PersonHandler;
import com.ceiba.domain.entity.Person;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/people")
public class DemoRestController{
    private PersonHandler personHandler;

    public DemoRestController(PersonHandler personHandler){
        this.personHandler = personHandler;
    }

    @PostMapping
    public void insert(@RequestBody PersonCommand personCommand){
        this.personHandler.create(personCommand);
    }

    @PutMapping
    public void update(@RequestBody PersonCommand personCommand){
        this.personHandler.create(personCommand);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id){
        this.personHandler.delete(id);
    }

    @GetMapping
    public List<Person> list() {
        return this.personHandler.list();
    }
    
}