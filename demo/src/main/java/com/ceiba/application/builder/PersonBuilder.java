package com.ceiba.application.builder;

import com.ceiba.application.command.PersonCommand;
import com.ceiba.domain.model.Person;

import org.springframework.stereotype.Component;

@Component
public class PersonBuilder{
    public Person build(PersonCommand personCommand){
        return new Person(personCommand.getId(),personCommand.getName());
    }
} 