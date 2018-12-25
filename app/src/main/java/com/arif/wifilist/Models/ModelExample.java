package com.arif.wifilist.Models;

public class ModelExample {

    private String name;
    private String address;
    private int photoId;

    public ModelExample(String name, String address, int photoId) {
        this.name = name;
        this.address = address;
        this.photoId = photoId;

    }

    public int getPhotoId() {
        return photoId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
