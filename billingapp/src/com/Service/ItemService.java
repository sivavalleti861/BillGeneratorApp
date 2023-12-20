package com.Service;


import com.Repository.ItemRepository;

public class ItemService {

    private ItemRepository itemRepository;

    public ItemService() {
        this.itemRepository = new ItemRepository();
    }

    public void showMenu() {
        itemRepository.showMenu();
    }

    public double getItemPrice(int itemId) {
        return itemRepository.getItemPrice(itemId);
    }
}
