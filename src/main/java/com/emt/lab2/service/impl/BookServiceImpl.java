package com.emt.lab2.service.impl;

import com.emt.lab2.model.Author;
import com.emt.lab2.model.Book;
import com.emt.lab2.model.Category;
import com.emt.lab2.repository.AuthorRepository;
import com.emt.lab2.repository.BooksRepository;
import com.emt.lab2.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BooksRepository booksRepository,AuthorRepository authorRepository) {
        this.booksRepository = booksRepository;
        this.authorRepository = authorRepository;

    }

    @Override
    public List<Book> findAll() {
        return this.booksRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.booksRepository.findById(id);
    }

    @Override
    public Optional<Book> save(String name, Category category, Long authorId, int availableCopies) {
        Author author = this.authorRepository.findById(authorId).orElseThrow(()->new RuntimeException("Author not found -book service save()"));
        Book b = new Book();
        b.setName(name);
        b.setAuthor(author);
        b.setCategory(category);
        b.setAvailableCopies(availableCopies);
        this.booksRepository.save(b);
        return Optional.of(b);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, int availableCopies) {
        Author author = this.authorRepository.findById(authorId).orElseThrow(()->new RuntimeException("Author not found -book service save()"));
        Book book = findById(id).orElseThrow(()-> new RuntimeException("Book not found -book service edit()"));
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        this.booksRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.booksRepository.deleteById(id);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = findById(id).orElseThrow(()-> new RuntimeException("Book not found -book service markAsTaken()"));
        int beforeMarkCopies = book.getAvailableCopies();
        book.setAvailableCopies(beforeMarkCopies - 1);
        this.booksRepository.save(book);
        return Optional.of(book);
    }
}
