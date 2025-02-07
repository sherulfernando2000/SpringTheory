package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("character")
public class CharacterMapping {

    @GetMapping(path = "test1/G????")
    public String test1(){
        return "test1 method invoked.";
    }

    @GetMapping(path = "????/test2")
    public String test2(){
        return "test2 method invoked.";
    }

}
