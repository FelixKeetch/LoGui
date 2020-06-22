package com.localguide.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hobbies")
@Getter
@Setter

public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "hobbies")
    private Set<User> passionates  = new HashSet<>();
}
