package com.emt.lab2.service;

import com.emt.lab2.model.Book;
import com.emt.lab2.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);
    Optional<Book> save(String name, Category category,Long authorId,int availableCopies);
    Optional<Book> edit(Long id,String name, Category category,Long authorId,int availableCopies);
    void deleteById(Long id);
    Optional<Book> markAsTaken(Long id);
}
