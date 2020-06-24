package com.localguide.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usrs")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long        id;
    private String      email;
    private String      password;
    private String      firstname;
    private String      lastname;
    private Date        birthdate;

    @ManyToMany
    @JoinTable(
            name               = "user_hobby",
            joinColumns        = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id"))
    private Set<Hobby> hobbies = new HashSet<>();

    @OneToMany( targetEntity = City.class,
                cascade      = CascadeType.ALL,
                fetch        = FetchType.LAZY,
                orphanRemoval = true)
    private Set<Language> languages = new HashSet<>();

// TODO  private Set<Roles>  roles;
    @OneToMany( targetEntity = City.class,
                cascade      = CascadeType.ALL,
                fetch        = FetchType.LAZY,
                orphanRemoval = true)//for the future, not sure if we should
                                     //remove the trips from DB if we remove the user
    private Set<Trip> guideTrips  = new HashSet<>();

    @OneToMany( targetEntity = City.class,
                cascade      = CascadeType.ALL,
                fetch        = FetchType.LAZY,
                orphanRemoval = true)
    private Set<Trip> touristTrips  = new HashSet<>();

    @OneToMany( targetEntity = City.class,
                cascade      = CascadeType.ALL,
                fetch        = FetchType.LAZY,
                orphanRemoval = true)
    private Set<Review> guideReviews  = new HashSet<>();

    @OneToMany( targetEntity = City.class,
                cascade      = CascadeType.ALL,
                fetch        = FetchType.LAZY,
                orphanRemoval = true)
    private Set<Review> touristReviews  = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private City city;
}
