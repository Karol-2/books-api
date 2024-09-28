package com.example.booksapi.services;

import com.example.booksapi.models.Book;
import com.example.booksapi.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository
    }

    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }
}
