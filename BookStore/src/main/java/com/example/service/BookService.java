package com.example.service;

import java.util.List;

import com.example.entity.Book;

public interface BookService {

    Book save(Book theBOOk);

    List<Book> findAll();

    Book findById(int theId);

    void deleteById(int theId);

}
