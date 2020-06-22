package com.localguide.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cities")
@Getter
@Setter

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Country country;

    @OneToMany( targetEntity = User.class,
                cascade = CascadeType.ALL,
                fetch   = FetchType.LAZY,
                orphanRemoval = true)
    private Set<User> inhabitats = new HashSet<>();
}
