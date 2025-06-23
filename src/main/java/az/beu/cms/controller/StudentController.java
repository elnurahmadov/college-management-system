package az.beu.cms.controller;

import az.beu.cms.model.student.*;
import az.beu.cms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<Void> addStudent(@RequestBody StudentRequest studentRequest) {
        studentService.addStudent(studentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{username}")
    public StudentResponse getStudentByUsername(@PathVariable String username) {
        return studentService.getStudentByUsername(username);
    }

    @GetMapping()
    public StudentsResponse getStudents() {
        return studentService.getStudents();
    }

    @PostMapping()
    public StudentsResponse getStudentsByCriteria(@RequestBody StudentRequest studentRequest) {
        return studentService.getStudentsByCriteria(studentRequest);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteStudentByUsername(@PathVariable String username) {
        studentService.deleteStudentByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/student/register-student-to-course")
    public ResponseEntity<Void> registerStudentToCourse(@RequestBody StudentCourseRequest studentCourseRequest) {
        studentService.registerStudentToCourse(studentCourseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/students-by-course-id/{courseId}")
    public StudentsWithCourses getStudentsByCourseId (@PathVariable UUID courseId) {
        return studentService.getStudentsByCourseId(courseId);
    }

}
