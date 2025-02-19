package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("form")
public class FormDataController {

    //id - 1
    //name -sherul
    //address - galle
    //http://localhost:8080/1_Rest_Controllers_Web_exploded/form  use x-www-form-urlencoded in postman

    @PostMapping
    public String test1(@RequestParam("id") String id, @RequestParam("name") String name ,@RequestParam("address") String address ){
        return id +" " + name + " " + address;

    }


    @PostMapping(path = "test2")
    public String test2(@ModelAttribute CustomerDTO customerDTO){
        return customerDTO.toString();

    }



}
