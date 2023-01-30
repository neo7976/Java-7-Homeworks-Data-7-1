package com.example.java7homeworksdata41.repository;

import com.example.java7homeworksdata41.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepositoryImp {

    private final PersonRepository personRepository;

    public PersonRepositoryImp(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> findAllByCityOrderBySurname(String city) {
        return personRepository.findAllByCityOrderBySurname(city);
    }

    public List<Person> findByAgeLessThanOrderByAge(int age) {
        return personRepository.findByAgeLessThanOrderByAge(age);
    }

    public Optional<Person> findByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}
