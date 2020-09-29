package com.jnelsonjava.songr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // route to hello world
    @GetMapping("/hello")
    public String showHello() {
        return "hello";
    }
}
