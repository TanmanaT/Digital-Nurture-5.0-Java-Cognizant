package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Constructor for constructor injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Constructor injection invoked.");
    }

    // Default constructor for setter injection
    public BookService() {
        System.out.println("BookService: Default constructor invoked.");
    }

    // Setter for setter injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: Setter injection invoked.");
    }

    public void printServiceMessage() {
        System.out.println("BookService: Hybrid injection service is running.");
        if (bookRepository != null) {
            bookRepository.printRepositoryMessage();
        }
    }
}
