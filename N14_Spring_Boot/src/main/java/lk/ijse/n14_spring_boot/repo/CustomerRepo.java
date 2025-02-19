package lk.ijse.n14_spring_boot.repo;

import jakarta.persistence.Entity;
import lk.ijse.n14_spring_boot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    boolean existsByName(String name);
}
