package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printServiceMessage() {
        System.out.println("BookService: Service method printServiceMessage is executed.");
        if (bookRepository != null) {
            bookRepository.printRepositoryMessage();
        }
    }
}
