package lk.ijse.controller;

import org.springframework.web.bind.annotation.*;

@RestController //meka interface ekakin implement welatiyenne eke @component thiyanawa
@RequestMapping("hello")
//@Component
public class HelloController {
    public HelloController() {
        System.out.println("HelloController");
    }

    @GetMapping
    public String sayHello() {
        return "get mapping invoked";
    }

    @PostMapping
    public String sayHelloPost() {
        return "post mapping invoked";
    }

    @DeleteMapping
    public String sayHelloDelete() {
        return "Delete mapping invoked";
    }


    @PutMapping
    public String sayHelloPut() {
        return "put mapping invoked";
    }

    @PatchMapping
    public String sayHelloPath() {
        return "post mapping invoked";
    }


}
