package lk.ijse.n14_spring_boot.service;

import jakarta.persistence.criteria.Order;
import lk.ijse.n14_spring_boot.dto.OrderDTO;
import lk.ijse.n14_spring_boot.dto.OrderDetailsDTO;
import lk.ijse.n14_spring_boot.dto.PlaceOrderDTO;
import lk.ijse.n14_spring_boot.entity.Customer;
import lk.ijse.n14_spring_boot.entity.Item;
import lk.ijse.n14_spring_boot.entity.OrderDetails;
import lk.ijse.n14_spring_boot.entity.Orders;
import lk.ijse.n14_spring_boot.repo.ItemRepo;
import lk.ijse.n14_spring_boot.repo.OrderDetailRepo;
import lk.ijse.n14_spring_boot.repo.OrderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ModelMapper modelMapper;


    /*@Override
     @Transactional
    public void placeOrder(PlaceOrderDTO placeOrderDTO) {
        OrderDTO orderDTO = placeOrderDTO.getOrderDTO();

        Orders ordersO = new Orders();
        ordersO.setId(orderDTO.getId());
        ordersO.setDate(orderDTO.getDate());
        ordersO.setTotal(orderDTO.getTotal());

        Customer customer = new Customer();
        customer.setId(orderDTO.getCustomerId());
        ordersO.setCustomer(customer);

        orderRepo.save(ordersO);

        List<OrderDetailsDTO> orderDetailsDTOs = placeOrderDTO.getOrderDetailsDTO();
        for (OrderDetailsDTO orderDetailsDTO : orderDetailsDTOs) {
            OrderDetails orderDetail = new OrderDetails();

            // Fetch existing item and order from DB (prevents detached entity issue)
            Item item = itemRepo.findById(orderDetailsDTO.getI_id())
                    .orElseThrow(() -> new RuntimeException("Item not found: " + orderDetailsDTO.getI_id()));
            Orders orderD = orderRepo.findById(orderDetailsDTO.getO_id())
                    .orElseThrow(() -> new RuntimeException("Order not found: " + orderDetailsDTO.getO_id()));


            orderDetail.setQuantity(orderDetailsDTO.getQuantity());
            orderDetail.setItem(item);
            orderDetail.setOrder(orderD);

            orderDetailRepo.save(orderDetail);

            // Update item quantity safely
            item.setQuantity(item.getQuantity() - orderDetail.getQuantity());
            itemRepo.save(item);
        }
    }*/

    @Override
    @Transactional
    public void placeOrder(PlaceOrderDTO placeOrderDTO) {

        try{
            OrderDTO orderDTO = placeOrderDTO.getOrderDTO();
            Orders ordersO = modelMapper.map(orderDTO, Orders.class);
            Orders savedOrder = orderRepo.save(ordersO);

            List<OrderDetailsDTO> orderDetailsDTOs = placeOrderDTO.getOrderDetailsDTO();
            for (OrderDetailsDTO orderDetailsDTO : orderDetailsDTOs) {

                Item item = itemRepo.findById(orderDetailsDTO.getI_id())
                        .orElseThrow(() -> new RuntimeException("Item not found: " + orderDetailsDTO.getI_id()));

                OrderDetails orderDetail = modelMapper.map(orderDetailsDTO, OrderDetails.class);
                orderDetail.setId(0);
                orderDetail.setItem(item);
                orderDetail.setOrder(savedOrder);
                orderDetailRepo.save(orderDetail);


                // Update item quantity safely
                item.setQuantity(item.getQuantity() - orderDetail.getQuantity());
                itemRepo.save(item);
            }
        }catch(Exception e){
            throw new RuntimeException("Error while place order: " + placeOrderDTO.getOrderDTO());
        }




    }






    /*@Override
    @Transactional
    public void placeOrder(PlaceOrderDTO placeOrderDTO) {
        *//*
        //qty management
        itemRepo.updateQty();
        //persist - order
        orderRepo.save(placeOrderDTO.getOrderDTO());
        //persist - orderdetails

        orderDetailRepo.save(orderDetailsDTO);
        *//*
        System.out.println("order from place order"+placeOrderDTO.getOrderDTO().getId());
        System.out.println("orderDetails from place order"+placeOrderDTO.getOrderDetailsDTO().get(0).getId());
        //Orders order = modelMapper.map(placeOrderDTO.getOrderDTO(), Orders.class);
        OrderDTO orderDTO = placeOrderDTO.getOrderDTO();
        Orders ordersO = new Orders();
        ordersO.setId(orderDTO.getId());
        ordersO.setDate(orderDTO.getDate());
        ordersO.setTotal(orderDTO.getTotal());

        Customer customer = new Customer();
        customer.setId(orderDTO.getCustomerId());
        ordersO.setCustomer(customer);

        orderRepo.save(ordersO);
        List<OrderDetailsDTO> orderDetailsDTOs = placeOrderDTO.getOrderDetailsDTO();
        for (OrderDetailsDTO orderDetailsDTO : orderDetailsDTOs) {
            OrderDetails orderDetail = new OrderDetails();
            int orderdetailId = orderDetailsDTO.getId();
            int quantity = orderDetailsDTO.getQuantity();
            int iId = orderDetailsDTO.getI_id();
            int oId = orderDetailsDTO.getO_id();

            Item item = new Item();
            item.setId(iId);

            Orders orderD = new Orders();
            orderD.setId(oId);

            orderDetail.setId(orderdetailId);
            orderDetail.setQuantity(quantity);
            orderDetail.setItem(item);
            orderDetail.setOrder(orderD);

            orderDetailRepo.save(orderDetail);
            int id = orderDetail.getItem().getId();
            int qty = orderDetail.getQuantity();
            itemRepo.updateQty(id,qty);
        }

    }*/
}
