package com.kyle.webclientpractice;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class WebClientTest {
    @Test
    void test1_3() {

        WebClient webClient = WebClient.create();
        Mono<String> hello = webClient.get()
                .uri("http://localhost:8080/practice/test")
                .retrieve()
                .bodyToMono(String.class);
        String response = hello.block();
        System.out.println(response);
    }
}
