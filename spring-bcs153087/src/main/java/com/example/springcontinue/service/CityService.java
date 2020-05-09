package com.example.springcontinue.service;
import com.example.springcontinue.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.springcontinue.entity.City;
import com.example.springcontinue.entity.Country;
import com.example.springcontinue.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    public City addorUpgrade(City city){
        return cityRepository.save(city);
    }
        public boolean deleteById(int id){
            cityRepository.deleteById(id);
            return true;

        }
    public List<City> getAll(){
        return cityRepository.findAll();
    }
    public City getById(int id){
        return cityRepository.findById(id).get();
    }

}
