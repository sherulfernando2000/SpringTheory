package lk.ijse.n14_spring_boot.repo;

import jakarta.persistence.Entity;
import lk.ijse.n14_spring_boot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    //find, read, query, get, count
    boolean existsByName(String name);
    List<Customer> findByAddress(String name);
    List<Customer> readCustomerByAddress(String address);
    List<Customer> getCustomerByName(String address);
    long countCustomerByAddress(String address);
    boolean existsCustomerByAddress(String address);

    @Query(value = "select * from Customer", nativeQuery = true)
    List<Customer> getAllCustomers();

    @Query(value = "select * from Customer where name=?1", nativeQuery= true)
    Customer searchcustomerbyname(String name);



}
