package lk.ijse.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //meka interface ekakin implement welatiyenne eke @component thiyanawa
@RequestMapping("hello")
//@Component
public class HelloController {
    public HelloController() {
        System.out.println("HelloController");
    }

    @GetMapping
    public String sayHello() {
        return "index";
    }

    /*@GetMapping("/test1")
    public String test1(){
        return "Hello World";
    }

    @GetMapping("/test")
    public String test(){
        return "Test";
    }*/
}
