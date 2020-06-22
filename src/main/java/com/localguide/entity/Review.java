package com.localguide.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String text;

    @OneToOne(mappedBy = "review")
    private Trip trip;
}
