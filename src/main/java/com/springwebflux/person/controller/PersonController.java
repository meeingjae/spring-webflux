package com.springwebflux.person.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springwebflux.person.repository.PersonRepository;
import com.springwebflux.person.vo.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping(value = "/{id}")
    public Mono<Person> findById(
            @PathVariable(value = "id") long id) {
        return personRepository.findById(id);
    }

    @GetMapping
    public Flux<Person> findAll() {
        return personRepository.findAll();
    }
}
