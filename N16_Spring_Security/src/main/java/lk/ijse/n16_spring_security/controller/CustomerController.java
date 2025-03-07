package lk.ijse.n16_spring_security.controller;


import jakarta.servlet.http.HttpServletRequest;
import lk.ijse.n16_spring_security.entity.Customer;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    public List<Customer> customers = new ArrayList<Customer>(
            List.of(new Customer(1,"sherul"), new Customer(2,"shenal"))
    );

    @GetMapping("csrf")
    public CsrfToken getToker(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("save")
    public Customer saveCustomer(@RequestBody Customer customer){
            return customer;
    }

    @GetMapping("get")
    public List<Customer> getCustomers(){
        return customers;
    }
}
