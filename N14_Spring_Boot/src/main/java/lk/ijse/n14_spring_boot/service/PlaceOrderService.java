package lk.ijse.n14_spring_boot.service;

import lk.ijse.n14_spring_boot.dto.PlaceOrderDTO;
import lk.ijse.n14_spring_boot.entity.Orders;

public interface PlaceOrderService {

    public void placeOrder(PlaceOrderDTO order);
}
