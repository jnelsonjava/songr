package com.jnelsonjava.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CapitalizeController {

    // route capitalizes the path variable passed to inputPhrase
    @GetMapping("/capitalize/{inputPhrase}")
    public String showCapitalize(Model mCapitalize, @PathVariable String inputPhrase) {

        // reference for toUpperCase method https://www.tutorialspoint.com/java/java_string_touppercase.htm
        mCapitalize.addAttribute("phrase", inputPhrase.toUpperCase());
        return "capitalize";
    }
}
