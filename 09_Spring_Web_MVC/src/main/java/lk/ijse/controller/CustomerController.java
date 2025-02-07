package lk.ijse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//JavaEE
//Diployment discipter web.xml --> URL pattern ? (Localhost: 8080/new_exploded/customer)
// customer --> customer servlet map karanawa

//WebMVC
//dispatcher servlet -> catch request (localhost: 8080/new_exploded/customer)
//customer -> controller
// url pattern --> requestMapping




@RestController
@RequestMapping("customer")
public class CustomerController{

    @GetMapping
    public String getCustomer(){
        return "Customer Controller";
    }
}
