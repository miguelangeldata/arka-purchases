package com.store.purchases;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestApplication {
    @GetMapping
    public String helloWorld(){
        return "Hi from purchase microservice";
    }

}
