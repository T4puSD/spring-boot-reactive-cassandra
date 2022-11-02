package com.tapusd.reactivecassandra.service;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.tapusd.reactivecassandra.domain.Course;
import com.tapusd.reactivecassandra.dto.request.CourseDTO;
import com.tapusd.reactivecassandra.dto.request.ModuleDTO;
import com.tapusd.reactivecassandra.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Flux<Course> all() {
        return courseRepository.findAll();
    }

    @Override
    public Mono<Course> save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Mono<Course> save(CourseDTO courseDTO) {
        var course = new Course();
        course.setCourseId(Uuids.random());
        course.setName(courseDTO.name());
        course.setModuleId(Uuids.random());
        course.setModuleName(courseDTO.moduleName());
        return save(course);
    }

    @Override
    public Mono<Course> saveNewModule(UUID courseId, ModuleDTO moduleDTO) {
        if (Objects.isNull(courseId)) {
            return Mono.empty();
        }

        return courseRepository.findById(courseId)
                .flatMap(course -> {
                    course.setModuleId(UUID.randomUUID());
                    course.setModuleName(moduleDTO.moduleName());
                    return save(course);
                });
    }
}
