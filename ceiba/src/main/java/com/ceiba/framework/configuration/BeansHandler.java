package com.ceiba.framework.configuration;

import com.ceiba.application.builder.PersonBuilder;
import com.ceiba.application.command.PersonCommand;
import com.ceiba.application.handler.PersonHandler;
import com.ceiba.domain.repository.PersonRepository;
import com.ceiba.domain.service.PersonService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansHandler {
    @Bean
    public PersonService personService(PersonRepository personRepository) {
        return new PersonService(personRepository);
    }

    @Bean
    public PersonCommand PersonCommand() {
        return new PersonCommand();
    }

    @Bean
    public PersonBuilder personBuilder() {
        return new PersonBuilder();
    }

    @Bean
    public PersonHandler personHandler(PersonService personService, PersonBuilder personBuilder) {
        return new PersonHandler(personService, personBuilder);
    }
}