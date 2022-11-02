package com.tapusd.reactivecassandra.service;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.tapusd.reactivecassandra.domain.Author;
import com.tapusd.reactivecassandra.dto.request.AuthorDTO;
import com.tapusd.reactivecassandra.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Flux<Author> all() {
        return authorRepository.findAll();
    }

    @Override
    public Mono<Author> save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Mono<Author> save(AuthorDTO authorDTO) {
        var author = new Author();
        author.setAuthorId(Uuids.random());
        author.setName(authorDTO.name());
        author.setImageUrl(authorDTO.imageUrl());
        author.setBiography(authorDTO.biography());
        return save(author);
    }
}
