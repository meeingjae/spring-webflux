package com.springwebflux.person.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springwebflux.person.vo.Person;
import com.springwebflux.person.vo.Person.Sex;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersonRepository {

    private static final Map<Long, Person> personMap;

    static {
        personMap = new HashMap<>();
        personMap.put(1L, new Person(1, "mingble", Sex.MALE));
        personMap.put(2L, new Person(2, "innible", Sex.FEMALE));
        personMap.put(3L, new Person(3, "ddangkong", Sex.MALE));
        personMap.put(4L, new Person(4, "hodu", Sex.MALE));
    }

    public Mono<Person> findById(long id) {
        return Mono.just(personMap.get(id));
    }

    public Flux<Person> findAll() {
        return Flux.fromIterable(personMap.values());
    }
}
