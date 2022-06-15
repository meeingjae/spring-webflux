package com.springwebflux.person.service;

import com.springwebflux.person.vo.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

    Mono<Person> findById(long id);

    Flux<Person> findAll();
}
