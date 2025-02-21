package lk.ijse.n14_spring_boot.controller;


import lk.ijse.n14_spring_boot.dto.CustomerDTO;
import lk.ijse.n14_spring_boot.dto.ItemDTO;
import lk.ijse.n14_spring_boot.entity.Customer;
import lk.ijse.n14_spring_boot.service.CustomerServiceImpl;
import lk.ijse.n14_spring_boot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("get")
    public List<CustomerDTO> getCustomer(){
        return customerService.getAll() ;
    }


    @PostMapping("save")
    public ResponseUtil saveCustomer(@RequestBody CustomerDTO customerDTO){
            customerService.addCustomer(customerDTO);
            return new ResponseUtil(201,"Customer saved.",null);


    }




    @PutMapping("update")
    public ResponseUtil updateCustomer(@RequestBody  CustomerDTO customerDTO){
         customerService.updateCustomer(customerDTO);
        return new ResponseUtil(201,"Customer saved.",null);
    }
    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return new ResponseUtil(201,"Customer saved.",null);
    }


}
