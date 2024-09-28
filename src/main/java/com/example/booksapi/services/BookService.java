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
        this.bookRepository = bookRepository;
        initializeData();
    }

    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    public Book getBookById(Long id) throws RuntimeException{
        return this.bookRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Book not found with id: " + id));
    }

    private void initializeData() {
        if (bookRepository.count() == 0) {
            // Add mock data
            Book book1 = new Book("To Kill a Mockingbird","Harper Lee",1960,3.5);
            Book book2 = new Book("Animal Farm","George Orwell",1945,2.2);
            Book book3 = new Book("1984","George Orwell",1951,5.0);
            Book book4 = new Book("Harry Potter and the Sorcerer’s Stone","J.K. Rowling",1997,4.5);
            Book book5 = new Book("The Catcher in the Rye","J.D. Salinger",1945,2.1);
            Book book6 = new Book("Harry Potter and the Goblet of Fire","J.K. Rowling",2000,4.9);

            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);
            bookRepository.save(book4);
            bookRepository.save(book5);
            bookRepository.save(book6);

            System.out.println("Added mock data to the database.");
        }
    }


}
