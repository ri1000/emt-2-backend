package com.emt.lab2.components;


import com.emt.lab2.service.AuthorService;
import com.emt.lab2.service.BookService;
import com.emt.lab2.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInit {

    private final CountryService countryService;
    private final BookService bookService;
    private final AuthorService authorService;

    public DataInit(CountryService countryService,BookService bookService,AuthorService authorService) {
        this.countryService = countryService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @PostConstruct
    public void initData(){
        this.countryService.save("Macedonia","Europe");
        this.countryService.save("Mexico","South America");
        this.countryService.save("USA","North America");
        this.countryService.save("Japan","Asia");



    }

}
