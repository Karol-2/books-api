package com.example.booksapi.controllers;

import com.example.booksapi.models.Book;
import com.example.booksapi.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> getAll(){
        return this.bookService.getAllBooks();
    }

}
