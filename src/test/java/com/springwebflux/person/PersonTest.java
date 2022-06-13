package com.springwebflux.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import com.springwebflux.person.controller.PersonController;
import com.springwebflux.person.repository.PersonRepository;
import com.springwebflux.person.vo.Person;

import reactor.core.publisher.Mono;

@SpringBootTest
class PersonTest {

    @Autowired
    PersonController personController;

    @Autowired
    PersonRepository personRepository;

    final WebClient client = WebClient.create("http://localhost:8080");

    @Test
    void 성공() {
        Mono<Person> personMono = client.get()
                                        .uri("/person/{id}",1)
                                        .retrieve()
                                        .bodyToMono(Person.class);

        personMono.subscribe(System.out::println);
        assertThat(personMono.block().getId())
                .isEqualTo(1);
    }

}
