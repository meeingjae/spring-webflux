package com.springwebflux.person.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.springwebflux.person.repository.PersonRepository;
import com.springwebflux.person.service.PersonService;
import com.springwebflux.person.service.PersonServiceImpl;

@Configuration
public class PersonConfig {

    @Primary
    @Bean
    public PersonService getPersonConfig() {
        return new PersonServiceImpl(new PersonRepository());
    }
}
