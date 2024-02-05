package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
   
    private int id;

    @NotNull(message = "is required")
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "ONLY CHARS")
    @Column(name = "name")
    private String name;

    @NotNull(message = "is required")
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "ONLY CHARS")
    @Column(name = "author")
    private String author;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to  zero")
    @Column(name = "price")
    private double price;

    public Book(int id, String name, String author, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
    }

}
