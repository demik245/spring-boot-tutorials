package com.demik.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerClass {

    @GetMapping("/")
    public String welcomePage() {
        return "welcome";
    }
    @GetMapping("/welcome")
    public String welcome() {
        return "welcomes";
    }

}
