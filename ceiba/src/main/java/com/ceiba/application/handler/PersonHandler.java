package com.ceiba.application.handler;

import java.util.List;

import com.ceiba.application.builder.PersonBuilder;
import com.ceiba.application.command.PersonCommand;
import com.ceiba.domain.entity.Person;
import com.ceiba.domain.service.PersonService;

import org.springframework.stereotype.Component;

@Component
public class PersonHandler{
    
    private final PersonService personService;    
    private final PersonBuilder personBuilder;

    public PersonHandler(PersonService personService, PersonBuilder personBuilder){
        this.personService = personService;
        this.personBuilder = personBuilder;
    }

    public void create(PersonCommand personCommand){
        Person person = this.personBuilder.build(personCommand);
        this.personService.create(person);
    }

    public void delete(Integer id){        
        this.personService.delete(id);
    }

    public List list(){
        return this.personService.list();
    }
}