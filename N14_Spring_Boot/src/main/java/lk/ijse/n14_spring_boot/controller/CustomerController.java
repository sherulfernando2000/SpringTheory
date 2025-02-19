package lk.ijse.n14_spring_boot.controller;


import lk.ijse.n14_spring_boot.dto.CustomerDTO;
import lk.ijse.n14_spring_boot.dto.ItemDTO;
import lk.ijse.n14_spring_boot.entity.Customer;
import lk.ijse.n14_spring_boot.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        List<Customer> customers = customerService.getAll();
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
            customerDTOS.add(customerDTO);
        }

        return customerDTOS ;
    }


    @PostMapping("save")
    public boolean saveCustomer(@RequestBody CustomerDTO customerDTO){
        boolean isSaved = customerService.addCustomer(customerDTO);
        return isSaved;
    }

    @PutMapping("update")
    public boolean updateCustomer(@RequestBody  CustomerDTO customerDTO){
        boolean isUpdate = customerService.updateCustomer(customerDTO);
        return isUpdate;
    }
    @DeleteMapping(path = "delete/{id}")
    public boolean deleteCustomer(@PathVariable Integer id) {
        return customerService.deleteCustomer(id);
    }


}
