package lk.ijse.n14_spring_boot.service;

import lk.ijse.n14_spring_boot.dto.CustomerDTO;
import lk.ijse.n14_spring_boot.entity.Customer;

import java.util.List;


public interface CustomerService {
    public void addCustomer(CustomerDTO customerDTO);

    public List<CustomerDTO> getAll();

    public void updateCustomer(CustomerDTO customerDTO);

    public void deleteCustomer(int id);
}
