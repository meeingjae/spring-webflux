package com.springwebflux.person.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;

/**
 * @see <a href="https://spring.io/guides/gs/reactive-rest-service/">Spring Reactive Reference</a>
 * @see <a href="https://www.devkuma.com/docs/spring-webflux/#router-functions-%EB%AA%A8%EB%8D%B8">devkuma</a>
 */
@Configuration
public class HelloRouterConfig {

    /**
     * @see <a href="https://github.com/eugenp/tutorials/blob/master/spring-reactive/src/main/java/com/baeldung/reactive/webflux/functional/EmployeeFunctionalConfig.java">Baeldung Github Example</a>
     */
    @Bean
    void getSomeServiceOrRepository() {
        // some Service Or Repository
    }

    @Bean
    RouterFunction<ServerResponse> routes() {
        return RouterFunctions.route(
                RequestPredicates.GET("/hello"),
                request -> ServerResponse.ok().body(Flux.just("Hi", "There"), String.class));
    }

}
