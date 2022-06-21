package com.springwebflux.car.config;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
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
                request -> ok().body(
                        getCarRepository().getById(Long.parseLong(request.pathVariable("id"))),
                        Car.class));
    }

    @Bean
    RouterFunction<ServerResponse> getAllCar() {
        return RouterFunctions.route(
                RequestPredicates.GET("/car"),
                request -> ok().body(getCarRepository().getAll(), Car.class));
    }

    @Bean
    RouterFunction<ServerResponse> updateCar() {
        return RouterFunctions.route(
                RequestPredicates.PUT("/car"),
                request -> request
                        .body(toMono(Car.class))
                        .doOnNext(getCarRepository()::updateCar)
                        .then(ok().build()));
    }

    @Bean
    RouterFunction<ServerResponse> deleteCar() {
        return RouterFunctions.route(
                RequestPredicates.DELETE("/car/{id}"),
                request -> ok()
                        .body(getCarRepository().deleteById(Integer.parseInt(request.pathVariable("id"))),
                              Integer.class));
    }
}
