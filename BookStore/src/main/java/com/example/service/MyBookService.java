package com.example.service;

import java.util.List;

import com.example.entity.MyBook;

public interface MyBookService {

    MyBook save(MyBook theBOOk);

    List<MyBook> findAll();

    MyBook findById(int theId);

    void deleteById(int theId);

}
