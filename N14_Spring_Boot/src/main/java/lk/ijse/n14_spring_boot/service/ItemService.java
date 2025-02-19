package lk.ijse.n14_spring_boot.service;

import lk.ijse.n14_spring_boot.dto.ItemDTO;
import lk.ijse.n14_spring_boot.entity.Item;
import lk.ijse.n14_spring_boot.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService  {

    @Autowired
    public ItemRepo itemRepo;

    public List<ItemDTO> findAll() {
        List<Item> items =  itemRepo.findAll();
        List<ItemDTO> itemDTOS = new ArrayList<>();

        items.forEach(item -> {
            ItemDTO itemDTO = new ItemDTO(item.getId(),item.getDescription(),item.getPrice(),item.getQuantity());
            itemDTOS.add(itemDTO);
        });

        return itemDTOS;
    }

    public boolean saveItem(ItemDTO itemDTO){
        Item isSaved = itemRepo.save(new Item(itemDTO.getId(),itemDTO.getDescription(),itemDTO.getPrice(),itemDTO.getQuantity()));
        return isSaved != null;
    }

    public boolean updateItem(ItemDTO itemDTO){
        Item isSaved = itemRepo.save(new Item(itemDTO.getId(),itemDTO.getDescription(),itemDTO.getPrice(),itemDTO.getQuantity()));
        return isSaved != null;
    }


    public boolean deleteItem(int id){
        try {
            itemRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
