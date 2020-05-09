package com.example.springcontinue.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cId",referencedColumnName = "countryId")
    private List<City> cities;

}
