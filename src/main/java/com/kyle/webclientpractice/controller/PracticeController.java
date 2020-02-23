package com.kyle.webclientpractice.controller;

import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/practice")
public class PracticeController {

    private final WebClient webClient;


    public PracticeController(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8080").build();
    }

    @GetMapping("/users")
    public Mono<String> findByName() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(String.class);
    }
    @GetMapping("/test")
    public String getTest() {

        String msg = "success";
        System.out.println(msg);
        return msg;
    }

    @GetMapping("/hello")
    @ResponseBody
    public Publisher<String> handler() {
        return Mono.just("Hello world!");
    }

}