package lk.ijse.repository;

import lk.ijse.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public Customer findByFirstName(String firstName);

}
