package com.ceiba.domain.repository;

import com.ceiba.domain.entity.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer>{
    
}