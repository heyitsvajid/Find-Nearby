package com.nearby.vajidkagdi.nearby;

public class StoreModel {

    public String name, address;
    String lat,lng;
    String rating;

    public StoreModel(String name, String address, String lat, String lng, String rating) {
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "StoreModel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}