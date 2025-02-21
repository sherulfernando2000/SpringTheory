package lk.ijse.n14_spring_boot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private double total;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails;

    public Orders() {

    }

    public Orders(int id, Date date, double total, Customer customer, List<OrderDetails> orderDetails) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.customer = customer;
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
