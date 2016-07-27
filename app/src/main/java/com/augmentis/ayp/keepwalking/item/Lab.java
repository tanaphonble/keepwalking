package com.augmentis.ayp.keepwalking.item;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Tanaphon on 7/27/2016.
 */
public class Lab {

    List<Item> itemList;

    private static Lab instance;

    public static Lab getInstance() {
        if (instance == null)
            instance = new Lab();
        return instance;
    }

    private Lab() {
        itemList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Item item = new Item();
            item.setTitle("Title #" + i);
            itemList.add(item);
        }
    }

    public Item getItemById(UUID id){
        for(Item item : itemList)
            if (item.getId().equals(id))
                return item;
        return null;
    }

    public List<Item> getItems() {
        return itemList;
    }

}
