package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository theBookRepository) {
        this.bookRepository = theBookRepository;
    }

    @Override
    public Book save(Book theBOOk) {

        return bookRepository.save(theBOOk);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int theId) {
        Optional<Book> res = bookRepository.findById(theId);

        Book thBook = null;
        if (res.isPresent()) {
            thBook = res.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return thBook;
    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }
}
