package lk.ijse.n14_spring_boot.service;

import lk.ijse.n14_spring_boot.dto.CustomerDTO;
import lk.ijse.n14_spring_boot.entity.Customer;
import lk.ijse.n14_spring_boot.repo.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    public CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())) {
            throw  new RuntimeException("Customer already exists");
        }

        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepo.save(customer);

        /*if (customerRepo.existsByName(customerDTO.getName())) {   //Query by Method
            return false;
        }*/

        /*Customer customer = new Customer(    // model mapper eka use karala karanna puluwa
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress()
        );*/


    }

    @Override
    public List<CustomerDTO> getAll() {

       return modelMapper.map(customerRepo.findAll(),
                new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getId())) {
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        }
        throw new RuntimeException("Customer does not exist");

    }

    @Override
    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }



    /*@Override
    public boolean addCustomer(CustomerDTO customerDTO) {
        System.out.println("Service Method" + customerDTO.getAddress());

        *//*if (customerRepo.existsById(customerDTO.getId())) {
            return false;
        }*//*

        if (customerRepo.existsByName(customerDTO.getName())) {   //Query by Method
            return false;
        }

        *//*Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress()
        );*//*

        Customer customer = modelMapper.map(customerDTO, Customer.class);

        customerRepo.save(customer);
//      customerRepo.delete();

        return true;
    }

    @Override
    public List<CustomerDTO> getAll() {

        return modelMapper.map(customerRepo.findAll(),
                new TypeToken<List<CustomerDTO>>() {}.getType());



       *//* List<CustomerDTO> customerDTOS = new ArrayList<>();
        List<Customer> customers = customerRepo.findAll();
        for(Customer customer : customers){
            CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;*//*
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        *//*Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getAddress()
        );*//*
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customerRepo.save(customer);
        return true;
    }*/

}
