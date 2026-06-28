package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void printServiceMessage() {
        System.out.println("BookService: Annotation-configured Service layer method is executed.");
        if (bookRepository != null) {
            bookRepository.printRepositoryMessage();
        }
    }
}
