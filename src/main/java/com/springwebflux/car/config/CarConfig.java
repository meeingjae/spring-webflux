package com.springwebflux.car.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springwebflux.car.repository.CarRepository;

@Configuration
public class CarConfig {

    @Bean
    public CarRepository getCarService() {
        return new CarRepository();
    }
}
