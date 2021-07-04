package com.example.restfulwebservice.web;

import java.util.concurrent.atomic.AtomicLong;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulwebservice.dto.Greeting;

@RestController
@Validated
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "World") @Length(max = 20) String name) {
        var greeting = new Greeting();
        greeting.setId(counter.incrementAndGet());
        greeting.setContent("Hello, " + name);

        return greeting;
    }
}
