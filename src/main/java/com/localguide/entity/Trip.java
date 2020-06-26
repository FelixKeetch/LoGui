package com.localguide.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "trips")
@Getter
@Setter

public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date tripDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User guide;

    @ManyToOne(fetch = FetchType.LAZY)
    private User tourist;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id", referencedColumnName = "id")
    private Review review;
}
