package com.sumo.kiraya.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "house")
public class House {
    private String type;
    private String description;
    private int rent;
    private String location;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


    public int getRent() {
        return rent;
    }
    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "House{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", rent=" + rent +
                ", location='" + location + '\'' +
                '}';
    }
}
