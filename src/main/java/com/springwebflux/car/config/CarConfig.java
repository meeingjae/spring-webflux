package com.springwebflux.car.config;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.springwebflux.car.repository.CarRepository;
import com.springwebflux.car.vo.Car;

@Configuration
public class CarConfig {

    @Bean
    public CarRepository getCarRepository() {
        return new CarRepository();
    }

    @Bean
    RouterFunction<ServerResponse> getCarByIdRoute() {
        return RouterFunctions.route(
                RequestPredicates.GET("/car/{id}"),
                req -> ok().body(
                        getCarRepository().getById(Long.parseLong(req.pathVariable("id"))),
                        Car.class));
    }
}
