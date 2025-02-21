package lk.ijse.n14_spring_boot.service;

import lk.ijse.n14_spring_boot.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    public List<ItemDTO> findAll();

    public boolean saveItem(ItemDTO itemDTO);

    public boolean updateItem(ItemDTO itemDTO);

    public boolean deleteItem(int id);

    public ItemDTO findItemById(int id);
}
