package lk.ijse.n14_spring_boot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class OrderDetailsDTO {
       private int id;
       private int quantity;
       private int i_id;
       private int o_id;

    public OrderDetailsDTO() {

    }

    public OrderDetailsDTO(int id, int quantity, int i_id, int o_id) {
        this.id = id;
        this.quantity = quantity;
        this.i_id = i_id;
        this.o_id = o_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }
}
