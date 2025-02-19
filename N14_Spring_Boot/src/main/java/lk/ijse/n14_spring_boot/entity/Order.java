package lk.ijse.n14_spring_boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Order {
    @Id
    private int id;
    private Date date;
    private double total;

    @ManyToOne
    private int customerId;
}
