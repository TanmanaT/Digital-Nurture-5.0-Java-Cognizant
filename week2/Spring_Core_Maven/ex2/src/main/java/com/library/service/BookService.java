package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printServiceMessage() {
        System.out.println("BookService: Service layer operations are running.");
        if (bookRepository != null) {
            System.out.print("Dependency injected successfully: ");
            bookRepository.printRepositoryMessage();
        } else {
            System.out.println("Dependency injection failed.");
        }
    }
}
