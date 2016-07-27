package com.augmentis.ayp.keepwalking.item;

import java.util.List;

/**
 * Created by Tanaphon on 7/27/2016.
 */
public class Lab {

    List<Item> itemList;

    private static Lab instance;

    public static Lab getInstance(){
        if (instance==null)
            instance = new Lab();
        return instance;
    }

}
