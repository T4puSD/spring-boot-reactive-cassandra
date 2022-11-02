package com.tapusd.reactivecassandra.repository;

import com.tapusd.reactivecassandra.domain.Course;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends ReactiveCassandraRepository<Course, UUID> {
}
