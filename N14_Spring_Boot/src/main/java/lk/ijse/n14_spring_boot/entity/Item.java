package lk.ijse.n14_spring_boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity

public class Item {
    @Id
    private int id;
    private String Description;
    private double price;
    private int quantity;

    @OneToMany(mappedBy = "item")
    private List<OrderDetails> orderDetails;

    public Item() {

    }

    public Item(int id, String description, double price, int quantity) {
        this.id = id;
        Description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", Description='" + Description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
