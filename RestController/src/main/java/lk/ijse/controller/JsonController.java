package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("json")
public class JsonController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String test1(@RequestBody CustomerDTO customerDTO){
        return customerDTO.toString();
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO test2( ){
        return new CustomerDTO("sherul","Fernando",11);
    }

    @GetMapping(path = "getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CustomerDTO> test3(){
        ArrayList<CustomerDTO> list = new ArrayList<>();
        list.add(new CustomerDTO("sherul","Fernando",11));
        list.add(new CustomerDTO("shenal","Fernando",12));
        list.add(new CustomerDTO("amal","Fernando",13));
        return list;
    }



}
