package com.sumo.kiraya.controller;

import com.sumo.kiraya.model.House;
import com.sumo.kiraya.repository.postRepo;
import com.sumo.kiraya.repository.searchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class HouseController {

    @Autowired
    postRepo postRepo;

    @Autowired
    searchRepo searchRepo;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

      @GetMapping("/houses")
      public List<House> getAllHouse(){
          return postRepo.findAll();
      }

      @GetMapping("/houses/{text}")
      public List<House> search(@PathVariable String text){
         return searchRepo.findByText(text);
      }

    @PostMapping("/house")
      public House addHouse(@RequestBody House house){
          return postRepo.save(house);
      }






}
