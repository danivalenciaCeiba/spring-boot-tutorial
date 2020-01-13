package com.ceiba.application.handler;

import com.ceiba.application.builder.PersonBuilder;
import com.ceiba.application.command.PersonCommand;
import com.ceiba.domain.model.Person;
import com.ceiba.domain.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("handler")
public class PersonHandler{
	
	@Autowired
    private final PersonService personService;
	
	@Autowired
    private final PersonBuilder personBuilder;

    public PersonHandler(PersonService personService, PersonBuilder personBuilder)
    {
        this.personService = personService;
        this.personBuilder = personBuilder;
    }

    public void create(PersonCommand personCommand){
        Person person = this.personBuilder.build(personCommand);
        this.personService.create(person);
    }
}