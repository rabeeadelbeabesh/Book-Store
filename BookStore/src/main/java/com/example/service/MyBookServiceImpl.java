package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.MyBook;
import com.example.repository.MyBookRepository;



@Service
public class MyBookServiceImpl implements MyBookService {
    private MyBookRepository myBookRepository;

    @Autowired
    public MyBookServiceImpl(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }

    @Override
    public MyBook save(MyBook theBOOk) {

        return myBookRepository.save(theBOOk);
    }

    @Override
    public List<MyBook> findAll() {
        return myBookRepository.findAll();
    }

    @Override
    public MyBook findById(int theId) {
        Optional<MyBook> res = myBookRepository.findById(theId);

        MyBook thBook = null;
        if (res.isPresent()) {
            thBook = res.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return thBook;
    }

    @Override
    public void deleteById(int theId) {
        myBookRepository.deleteById(theId);
    }
}
