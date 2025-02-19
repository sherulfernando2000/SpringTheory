package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exact")
public class ExactMappingController {

    @GetMapping(path = "test1")
    public String test1(){
        return "test1 method invoked.";
    }

    @GetMapping(path = "test2/sherul")
    public String test2(){
        return "test2 method invoked.";
    }


}
