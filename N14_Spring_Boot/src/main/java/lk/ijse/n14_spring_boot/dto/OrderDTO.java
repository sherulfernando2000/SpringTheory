package lk.ijse.n14_spring_boot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


public class OrderDTO {
   private int id;
   private Date date;
   private double total;
   private int customerId;

    public OrderDTO() {

    }

    public OrderDTO(int id, Date date, double total, int customerId) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.customerId = customerId;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
