package com.springwebflux.hello;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.springwebflux.TestBase;

import reactor.core.publisher.Flux;

public class HelloTest extends TestBase {


    @Disabled
    @Test
    void Hello_404() {
        //TODO: 404 NotFound 해결
        Flux<String> hello = client.get()
                                   .uri("/hello")
                                   .accept(MediaType.TEXT_PLAIN)
                                   .retrieve()
                                   .bodyToFlux(String.class);

        hello.subscribe(System.out::println);
        assertThat((int) hello.toStream().count())
                .isEqualTo(2);
    }
}
