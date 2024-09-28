package com.example.booksapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Integer year;
    private Integer rating;

    public Book(){}

    public Book(String title, String author, Integer year, Integer rating){
        this.title = title;
        this.author = author;
        this.year = year;
        this.rating = rating;
    }


}
