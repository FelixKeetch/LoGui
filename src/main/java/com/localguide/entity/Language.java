package com.localguide.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "languages")
@Getter
@Setter

public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String          name;
    @ManyToMany(mappedBy = "languages")
    private Set<User> speakers = new HashSet<>();

}
