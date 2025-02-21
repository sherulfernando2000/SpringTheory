package lk.ijse.n14_spring_boot.controller;

import lk.ijse.n14_spring_boot.dto.CustomerDTO;
import lk.ijse.n14_spring_boot.dto.ItemDTO;
import lk.ijse.n14_spring_boot.dto.PlaceOrderDTO;
import lk.ijse.n14_spring_boot.entity.Orders;
import lk.ijse.n14_spring_boot.service.CustomerService;
import lk.ijse.n14_spring_boot.service.ItemService;
import lk.ijse.n14_spring_boot.service.PlaceOrderService;
import lk.ijse.n14_spring_boot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private PlaceOrderService placeOrderService;

    @GetMapping("getAllCustomer")
    public List<CustomerDTO> getAllCustomer() {

        return customerService.getAll() ;
    }

    @GetMapping("getAllItems")
    public List<ItemDTO> getItems(){
        return itemService.findAll();
    }

    @GetMapping("getItemById/{id}")
    public ItemDTO getItemsByID(@PathVariable int id){
        return itemService.findItemById(id);
    }

    @PostMapping("placeOrder")
    public ResponseUtil placeOrder(@RequestBody PlaceOrderDTO placeOrderDTO){
            System.out.println(placeOrderDTO.getOrderDTO().getId());
            placeOrderService.placeOrder(placeOrderDTO);
            return new ResponseUtil(201,"Order placed sucess fully.",null);

    }



}
