package az.beu.cms.model.student;

import az.beu.cms.model.course.Course;
import az.beu.cms.model.course.CourseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentWithCourses {
    private UUID id;
    private String name;
    private String surname;
    private String middleName;
    private String email;
    private String username;
    private String departmentCode;
    private String classNumber;
    private String state;

    private List<Course> courses;
}

