package com.springwebflux.person;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springwebflux.TestBase;
import com.springwebflux.person.controller.PersonController;
import com.springwebflux.person.vo.Person;

import reactor.core.publisher.Mono;

@SpringBootTest
class PersonControllerTest extends TestBase {

    @Autowired
    PersonController personController;

    @Test
    void Person_성공() {
        Mono<Person> personMono = client.get()
                                        .uri("/person/{id}", 1)
                                        .retrieve()
                                        .bodyToMono(Person.class);

        personMono.subscribe(Person::getName);
        assertThat(personMono.block().getId())
                .isEqualTo(1);
    }
}
