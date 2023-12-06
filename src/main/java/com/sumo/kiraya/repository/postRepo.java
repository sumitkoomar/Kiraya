package com.sumo.kiraya.repository;

import com.sumo.kiraya.model.House;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface postRepo extends MongoRepository<House,String> {
}
