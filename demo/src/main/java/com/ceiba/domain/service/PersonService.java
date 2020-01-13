package com.ceiba.domain.service;

import org.springframework.stereotype.Service;

import com.ceiba.domain.model.Person;
import com.ceiba.domain.repository.IPersonRepository;

@Service
public class PersonService{
    private IPersonRepository personRepository;

    public PersonService(IPersonRepository personRepository)
    {
        this.personRepository = personRepository;        
    }

    public void create(Person person){
        this.personRepository.save(person);
    }
}