package com.spring.microservice.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String sayHelloWorld() {
        return "Say hello";
    }

    @GetMapping(path = "/hello/{message}")
    public HelloWorldBean sayHelloWorld(@PathVariable String message) {
        return new HelloWorldBean
                .builder(String.format("Say hello %s", message))
                .build();
    }
}
