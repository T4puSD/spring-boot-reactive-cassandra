package com.tapusd.reactivecassandra.repository;

import com.tapusd.reactivecassandra.domain.Author;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends ReactiveCassandraRepository<Author, UUID> {
}
