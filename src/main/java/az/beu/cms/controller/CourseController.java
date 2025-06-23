package az.beu.cms.controller;

import az.beu.cms.model.course.CourseRequest;
import az.beu.cms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<Void> addCourse(@RequestBody CourseRequest courseRequest) {
        courseService.addCourse(courseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String code) {
        courseService.deleteCourse(code);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
