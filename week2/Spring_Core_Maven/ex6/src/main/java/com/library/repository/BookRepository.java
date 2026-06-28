package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void printRepositoryMessage() {
        System.out.println("BookRepository: Annotation-configured DB layer method is executed.");
    }
}
