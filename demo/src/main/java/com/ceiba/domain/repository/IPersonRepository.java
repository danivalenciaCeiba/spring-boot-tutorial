package com.ceiba.domain.repository;

import com.ceiba.domain.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person,Integer>{
    public Person save(Person person);
}