package az.beu.cms.controller;

import az.beu.cms.model.teacher.TeacherRequest;
import az.beu.cms.model.teacher.TeacherResponse;
import az.beu.cms.model.teacher.TeachersResponse;
import az.beu.cms.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/teacher")
    public ResponseEntity<Void> addTeacher(@RequestBody TeacherRequest teacherRequest) {
        teacherService.addTeacher(teacherRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{username}")
    public TeacherResponse getTeacherByUsername(@PathVariable String username) {
        return teacherService.getTeacherByUsername(username);
    }

    @GetMapping()
    public TeachersResponse getTeachers() {
        return teacherService.getTeachers();
    }

    @PostMapping()
    public TeachersResponse getTeachersByCriteria(@RequestBody TeacherRequest teacherRequest) {
        return teacherService.getTeachersByCriteria(teacherRequest);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteTeacherByUsername(@PathVariable String username) {
        teacherService.deleteTeacherByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
