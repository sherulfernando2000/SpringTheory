package lk.ijse.n14_spring_boot.service;

import lk.ijse.n14_spring_boot.dto.CustomerDTO;
import lk.ijse.n14_spring_boot.entity.Customer;
import lk.ijse.n14_spring_boot.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    public CustomerRepo customerRepo;

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) {
        System.out.println("Service Method" + customerDTO.getAddress());

        /*if (customerRepo.existsById(customerDTO.getId())) {
            return false;
        }*/

        if (customerRepo.existsByName(customerDTO.getName())) {   //Query by Method
            return false;
        }

        Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress()
        );

        customerRepo.save(customer);
//      customerRepo.delete();

        return true;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = customerRepo.findAll();
        return customers;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress()
        );
        customerRepo.save(customer);
        return true;
    }

    @Override
    public boolean deleteCustomer(int id) {
        try {
            customerRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
