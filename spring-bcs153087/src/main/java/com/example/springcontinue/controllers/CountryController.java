package com.example.springcontinue.controllers;

import com.example.springcontinue.entity.City;
import com.example.springcontinue.entity.Country;
import com.example.springcontinue.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping
    private List<Country> getAll(){
        return CountryService.getAll();
    }
    @GetMapping("/{id}")
    private Country getById(@PathVariable int id){
        return CountryService.getById(id);
    }
    @PostMapping
    private ResponseEntity<?>add(@Valid @RequestBody Country country, BindingResult result){
        if(result.hasErrors()){
            Map<String,String> errors = new HashMap<>();
            for(FieldError error:result.getFieldErrors()){
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
       Country country1 =CountryService.addorUpgrade(country);
       return new ResponseEntity<Country>(country1,HttpStatus,HttpStatus.CREATED   )
    }
    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable int id, @Valid @RequestBody Country country){
        country.setCountryId(id);
            if(result.hasErrors()){
                Map<String,String> errors = new HashMap<>();
                for(FieldError error:result.getFieldErrors()){
                    errors.put(error.getField(),error.getDefaultMessage());
                }
                return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
                Country country1 =CountryService.addorUpgrade(country);
                return new ResponseEntity<Country>(country1,HttpStatus.HttpStatus.CREATED   )
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<?>  void delete(@PathVariable int id){
        countryService.deleteById(id);
                return new ResponseEntity< >(HttpStatus.OK)
    }
}
