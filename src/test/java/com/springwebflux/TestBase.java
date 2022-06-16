package com.springwebflux;

import org.springframework.web.reactive.function.client.WebClient;

public class TestBase {

    public final WebClient client = WebClient.create("http://localhost:8080");

}
