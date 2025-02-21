package lk.ijse.n14_spring_boot.repo;

import lk.ijse.n14_spring_boot.entity.Item;
import lk.ijse.n14_spring_boot.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

    @Modifying
    @Query(value = "update Item set quantity =?1 where id =?2", nativeQuery = true)
    void updateQty(int qty, int id);
}
