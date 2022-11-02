package com.tapusd.reactivecassandra.service;

import com.tapusd.reactivecassandra.domain.Course;
import com.tapusd.reactivecassandra.dto.request.CourseDTO;
import com.tapusd.reactivecassandra.dto.request.ModuleDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public interface CourseService {

    Flux<Course> all();

    Mono<Course> save(Course course);

    Mono<Course> save(CourseDTO courseDTO);

    Mono<Course> saveNewModule(UUID courseId, ModuleDTO moduleDTO);
}
