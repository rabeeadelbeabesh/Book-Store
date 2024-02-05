package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Book;
import com.example.entity.MyBook;
import com.example.service.BookServiceImpl;
import com.example.service.MyBookServiceImpl;

import jakarta.validation.Valid;

@Controller

public class BookController {


    // to remove all whit space 
    @InitBinder 
    public void InitBinder (WebDataBinder dataBinder){
        StringTrimmerEditor trimmerEditor=new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    private BookServiceImpl bookServiceImpl;
    private MyBookServiceImpl myBookServiceImpl;

    @Autowired
    public BookController(BookServiceImpl thBookServiceImpl, MyBookServiceImpl theMyBookServiceImpl) {
        this.myBookServiceImpl = theMyBookServiceImpl;
        this.bookServiceImpl = thBookServiceImpl;

    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(Model thModel) {

        Book thBook = new Book();

        thModel.addAttribute("book", thBook);

        return "bookRegister";
    }

    @GetMapping("/available_books")
    public String getAllBook(Model thModel) {
        List<Book> Books = bookServiceImpl.findAll();

        thModel.addAttribute("books", Books);

        return "bookList";
    }

    @GetMapping("/showFromForUpdateBook")
    public String showFromForUpdateBook(@RequestParam("bookID") int theId, Model thModel) {
        Book theBook = bookServiceImpl.findById(theId);

        thModel.addAttribute("book", theBook);

        return "bookRegister";
    }

    @GetMapping("/deletBook")
    public String deletBook(@RequestParam("bookID") int theId) {
        bookServiceImpl.deleteById(theId);

        return "redirect:/available_books";
    }

    @PostMapping("/saveBook")
    public String saveBook(@Valid @ModelAttribute("book") Book theBook ,BindingResult thBindingResult) {

        if(thBindingResult.hasErrors())
         return "bookRegister";

        
        bookServiceImpl.save(theBook);

        return "redirect:/available_books";
    }

    @GetMapping("/mybookList")

    public String mybooks(Model theModel) {

        List<MyBook> Books = myBookServiceImpl.findAll();

        theModel.addAttribute("books", Books);

        return "myList-books";
    }

    @GetMapping("/AddToMyBook")
    public String addToMyBook(@RequestParam("bookID") int bookID) {

        Book theBook =bookServiceImpl.findById(bookID);
        MyBook myBook=new MyBook(theBook);

         myBookServiceImpl.save(myBook);

        return "redirect:/mybookList";
    }
     @GetMapping("/deletMyBook")
    public String deletMyBook(@RequestParam("bookID") int theId) {
        myBookServiceImpl.deleteById(theId);

        return "redirect:/mybookList";
    }

}
