package lk.ijse.n14_spring_boot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class PlaceOrderDTO {
    private OrderDTO orderDTO;
    private List<OrderDetailsDTO> orderDetailsDTO;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(OrderDTO orderDTO, List<OrderDetailsDTO> orderDetailsDTO) {

        this.orderDTO = orderDTO;
        this.orderDetailsDTO = orderDetailsDTO;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public List<OrderDetailsDTO> getOrderDetailsDTO() {
        return orderDetailsDTO;
    }

    public void setOrderDetailsDTO(List<OrderDetailsDTO> orderDetailsDTO) {
        this.orderDetailsDTO = orderDetailsDTO;
    }
}
