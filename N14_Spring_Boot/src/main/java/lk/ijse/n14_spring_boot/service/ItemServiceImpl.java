package lk.ijse.n14_spring_boot.service;

import lk.ijse.n14_spring_boot.dto.ItemDTO;
import lk.ijse.n14_spring_boot.entity.Item;
import lk.ijse.n14_spring_boot.repo.ItemRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    public ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ItemDTO> findAll() {
        return modelMapper.map(itemRepo.findAll(),
                new TypeToken<List<ItemDTO>>() {}.getType()
        );
    }

    @Override
    public boolean saveItem(ItemDTO itemDTO){
        Item item = modelMapper.map(itemDTO, Item.class);
        Item isSaved = itemRepo.save(item);
        return isSaved != null;
    }


    @Override
    public boolean updateItem(ItemDTO itemDTO){
        Item item = modelMapper.map(itemDTO, Item.class);
        Item isUpdate = itemRepo.save(item);
        return isUpdate != null;
    }


    @Override
    public boolean deleteItem(int id){
        try {
            itemRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ItemDTO findItemById(int id){
        return modelMapper.map(itemRepo.findById(id).get(), ItemDTO.class);

    }


}
