package com.emt.lab2.model;


import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Author author;
    private int availableCopies;


    public Book(){

    }
}
