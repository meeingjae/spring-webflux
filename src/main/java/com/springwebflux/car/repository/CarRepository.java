package com.springwebflux.car.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springwebflux.car.vo.Car;

import reactor.core.publisher.Mono;

@Repository
public class CarRepository {
    private static final Map<Long, Car> carMap;

    static {
        carMap = new HashMap<>();
        carMap.put(1L, new Car(1L, "BMW", 50000000));
        carMap.put(2L, new Car(2L, "KIA", 25000000));
        carMap.put(3L, new Car(3L, "AUDI", 40000000));
        carMap.put(4L, new Car(4L, "PORSCHE", 90000000));
    }

    public Mono<Car> getById(long id) {
        return Mono.just(carMap.get(id) != null ? carMap.get(id) : new Car());
    }
}
