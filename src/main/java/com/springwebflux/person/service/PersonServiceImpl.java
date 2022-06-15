package com.springwebflux.person.service;

import org.springframework.stereotype.Service;

import com.springwebflux.person.repository.PersonRepository;
import com.springwebflux.person.vo.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Mono<Person> findById(long id) {
        return personRepository.findById(id);
    }

    @Override
    public Flux<Person> findAll() {
        return personRepository.findAll();
    }
}
