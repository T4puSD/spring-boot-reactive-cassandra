package com.tapusd.reactivecassandra.controller;

import com.tapusd.reactivecassandra.domain.Author;
import com.tapusd.reactivecassandra.dto.request.AuthorDTO;
import com.tapusd.reactivecassandra.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public Flux<Author> getAuthors() {
        return authorService.all();
    }

    @PostMapping()
    public Mono<Author> saveNewAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.save(authorDTO);
    }
}
