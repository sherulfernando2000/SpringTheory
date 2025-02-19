package lk.ijse.controller;


import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {


    List<CustomerDTO> customers = new ArrayList<>();

    @PostMapping(path = "save")
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO ) {
        System.out.println(customerDTO.getId());
        customers.add(customerDTO);
        return customerDTO;
    }


    @GetMapping(path = "getAll")
    public List<CustomerDTO> getCustomer(){
        return customers;

    }

    @PutMapping(path = "update")
    public CustomerDTO udateCustomer(@RequestBody CustomerDTO customerDTO){
       for (int i = 0; i < customers.size(); i++) {
           CustomerDTO existingCustomer = customers.get(i);
           if (existingCustomer.getId().equals(customerDTO.getId())) {
               existingCustomer.setName(customerDTO.getName());
               existingCustomer.setAddress(customerDTO.getAddress());
               return existingCustomer;
           }
       }
       return customerDTO;
    }

    @DeleteMapping(path = "delete/{id}")
    public Boolean deleteCustomer(@PathVariable("id") String id){
        for (int i = 0; i < customers.size(); i++) {
            CustomerDTO existingCustomer = customers.get(i);
            if (existingCustomer.getId().equals(id) ){
                customers.remove(i);
                return true;
            }
        }


        return false;
    }

}
