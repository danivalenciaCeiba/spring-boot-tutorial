package com.ceiba.domain.service;

import java.util.List;

import com.ceiba.domain.entity.Person;
import com.ceiba.domain.repository.PersonRepository;

import org.springframework.stereotype.Service;

@Service
public class PersonService{
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void create(Person person){
        this.personRepository.save(person);
    }

    public void delete(Integer id){
        this.personRepository.deleteById(id);
    }

    public List list(){
        return this.personRepository.findAll();
    }
}