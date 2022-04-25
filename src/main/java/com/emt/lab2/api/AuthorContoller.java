package com.emt.lab2.api;


import com.emt.lab2.model.Author;
import com.emt.lab2.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorContoller {

    private final AuthorService authorService;

    public AuthorContoller(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return this.authorService.findAll();
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestParam String name,@RequestParam String surname,
                                       @RequestParam Long countryId){
        return this.authorService.save(name,surname,countryId)
                .map( author ->  ResponseEntity.ok().body(author))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
