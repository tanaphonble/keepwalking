package com.augmentis.ayp.keepwalking.item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Tanaphon on 7/27/2016.
 */
public class Item {
    UUID _id;
    String _title;
    String _timeStamp;
    Date _currentTime = new Date();

    public Item() {
        _id = UUID.randomUUID();
        _timeStamp = getSimpleDateFormat(_currentTime);
    }

    public UUID getId() {
        return _id;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getSimpleDateFormat(Date date) {
        return new SimpleDateFormat("dd MMMM yyyy hh:mm:ss").format(date);
    }

    public String getTimeStamp() {
        return _timeStamp;
    }
}
