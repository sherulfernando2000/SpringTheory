package lk.ijse.n14_spring_boot.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class ItemDTO {

    private int id;
    private String description;
    private double price;
    private int quantity;

    public ItemDTO() {
    }

    public ItemDTO(int id, String description, double price, int quantity) {
        this.id = id;
        this.description = description;
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
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
