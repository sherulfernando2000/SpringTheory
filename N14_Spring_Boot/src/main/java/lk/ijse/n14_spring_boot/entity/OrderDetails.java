package lk.ijse.n14_spring_boot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity

public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "oId")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "iId")
    private Item item;

    private int quantity;

    @Version  // Hibernate will now check the version before updating.
    private int version;

    public OrderDetails() {

    }

    public OrderDetails(int id, Orders order, Item item, int quantity) {
        this.id = id;
        this.order = order;
        this.item = item;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
