package com.example.ryanr.monitoringaset.Model;

public class InventoryModel {
    String invenName,Date;
    int imageId;

    public InventoryModel() {
    }

    public InventoryModel(String invenName, String date, int imageId) {
        this.invenName = invenName;
        Date = date;
        this.imageId = imageId;
    }

    public String getInvenName() {
        return invenName;
    }

    public void setInvenName(String invenName) {
        this.invenName = invenName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
