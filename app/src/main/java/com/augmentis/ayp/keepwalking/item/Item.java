package com.augmentis.ayp.keepwalking.item;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Tanaphon on 7/27/2016.
 */
public class Item {
    UUID id;
    String title;
    Date timeStamp;

    public Item(UUID id, Date timeStamp) {
        this.id = id;
        this.timeStamp = timeStamp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
