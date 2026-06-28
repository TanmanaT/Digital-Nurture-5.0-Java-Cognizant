package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printServiceMessage() {
        System.out.println("BookService: Managing operations in central IoC container.");
        if (bookRepository != null) {
            bookRepository.printRepositoryMessage();
        }
    }
}
