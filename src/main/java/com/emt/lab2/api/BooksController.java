package com.emt.lab2.api;


import com.emt.lab2.model.Book;
import com.emt.lab2.model.Category;
import com.emt.lab2.model.Country;
import com.emt.lab2.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestParam String name, @RequestParam Category category,
                                     @RequestParam Long authorId, @RequestParam int availableCopies) {
        return this.bookService.save(name, category, authorId, availableCopies)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestParam String name, @RequestParam Category category,
                                     @RequestParam Long authorId, @RequestParam int availableCopies) {
        return this.bookService.edit(id, name, category, authorId, availableCopies)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if (this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/mark/{id}")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id){
        if (this.bookService.findById(id).isPresent()){
            return this.bookService.markAsTaken(id)
                    .map(book -> ResponseEntity.ok().body(book))
                    .orElseGet(() -> ResponseEntity.badRequest().build());
        }else{
            return ResponseEntity.badRequest().build();
        }

    }

}
