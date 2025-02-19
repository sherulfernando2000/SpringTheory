package lk.ijse.n14_spring_boot.controller;


import lk.ijse.n14_spring_boot.dto.ItemDTO;
import lk.ijse.n14_spring_boot.entity.Item;
import lk.ijse.n14_spring_boot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("get")
    public List<ItemDTO> getItems() {
       return itemService.findAll();
    }

    @PostMapping("save")
    public boolean saveItem(@RequestBody ItemDTO itemDTO) {
        System.out.println(itemDTO.getDescription()+" "+itemDTO.getQuantity()+" "+itemDTO.getPrice());
        return itemService.saveItem(itemDTO);
    }

    @PutMapping("update")
    public boolean updateItem(@RequestBody ItemDTO itemDTO) {
        System.out.println(itemDTO.toString());
        return itemService.updateItem(itemDTO);
    }

    @DeleteMapping(path = "delete/{id}")
    public boolean deleteItem(@PathVariable int id) {
        return itemService.deleteItem(id);
    }


}
