package com.sumo.kiraya.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sumo.kiraya.model.House;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class searchRepoImpl implements searchRepo{

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;
    @Override
    public List<House> findByText(String text) {
        List<House> houses = new ArrayList<>();
        MongoDatabase database = client.getDatabase("Kiraya");
        MongoCollection<Document> collection = database.getCollection("house");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", "mumbai")
                                .append("path", "location")))));
        result.forEach(doc -> houses.add(converter.read(House.class,doc)));
        return houses;

    }
}
