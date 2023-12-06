package com.sumo.kiraya.repository;

import com.sumo.kiraya.model.House;

import java.util.List;

public interface searchRepo {
    List<House> findByText(String text);
}
