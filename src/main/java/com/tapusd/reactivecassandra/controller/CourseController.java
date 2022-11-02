package com.tapusd.reactivecassandra.controller;

import com.tapusd.reactivecassandra.domain.Course;
import com.tapusd.reactivecassandra.dto.request.CourseDTO;
import com.tapusd.reactivecassandra.dto.request.ModuleDTO;
import com.tapusd.reactivecassandra.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public Flux<Course> getAllCourses() {
        return courseService.all();
    }

    @PostMapping()
    public Mono<Course> saveNewCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.save(courseDTO);
    }

    @PostMapping("/{courseId}/modules")
    public ResponseEntity<Mono<Course>> saveNewModule(@PathVariable UUID courseId, @RequestBody ModuleDTO moduleDTO) {
        return ResponseEntity.ok(courseService.saveNewModule(courseId, moduleDTO));
    }
}
