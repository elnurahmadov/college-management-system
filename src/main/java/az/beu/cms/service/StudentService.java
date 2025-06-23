package az.beu.cms.service;

import az.beu.cms.model.student.*;

import java.util.UUID;

public interface StudentService {

    void addStudent(StudentRequest studentRequest);

    StudentResponse getStudentByUsername(String username);

    StudentsResponse getStudents();

    StudentsResponse getStudentsByCriteria(StudentRequest studentRequest);

    void deleteStudentByUsername(String username);

    void registerStudentToCourse(StudentCourseRequest studentCourseRequest);

    StudentsWithCourses getStudentsByCourseId(UUID courseId);
}
