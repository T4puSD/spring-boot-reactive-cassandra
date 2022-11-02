package com.tapusd.reactivecassandra.service;

import com.tapusd.reactivecassandra.domain.Author;
import com.tapusd.reactivecassandra.dto.request.AuthorDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthorService {

    Flux<Author> all();

    Mono<Author> save(Author author);

    Mono<Author> save(AuthorDTO authorDTO);
}
