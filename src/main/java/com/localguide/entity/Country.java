package com.localguide.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="countries")
@Getter
@Setter

public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @OneToMany( targetEntity = City.class,
                cascade      = CascadeType.ALL,
                fetch        = FetchType.LAZY,
                orphanRemoval = true)
    private Set<City> cities = new HashSet<>();
}
