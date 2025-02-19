package lk.ijse.n14_spring_boot.service;

import lk.ijse.n14_spring_boot.dto.CustomerDTO;
import lk.ijse.n14_spring_boot.entity.Customer;

import java.util.List;


public interface CustomerService {
    public boolean addCustomer(CustomerDTO customerDTO);

    public List<Customer> getAll();

    public boolean updateCustomer(CustomerDTO customerDTO);

    public boolean deleteCustomer(int id);
}
