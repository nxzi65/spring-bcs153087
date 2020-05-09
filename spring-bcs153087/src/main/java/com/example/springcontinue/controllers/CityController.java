package com.example.springcontinue.controllers;

import com.example.springcontinue.entity.City;
import com.example.springcontinue.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping
    private List<City> getAll(){
        return cityService.getAll();
    }
    @GetMapping("/{id}")
    private City getById(@PathVariable int id){
        return cityService.getById(id);
    }
    @PostMapping
    private City add(@RequestBody City city){
        return cityService.addorUpgrade(city);
    }
    @PutMapping("/{id}")
    private City update(@PathVariable int id,@RequestBody City city){
        city.setCityId(id);
        return cityService.addorUpgrade(city);
    }
    @DeleteMapping("/{id}")
    private void delete(@PathVariable int id){
        cityService.deleteById(id);
    }
}