package az.beu.cms.mapstruct;

import az.beu.cms.model.course.Course;
import az.beu.cms.model.course.CourseDto;
import az.beu.cms.model.student.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class StudentMapStruct {

    public abstract StudentResponseDto map(StudentDto studentDto);

    @Mapping(target = "students", source = "studentDtos")
    public abstract StudentsResponse map(StudentsResponseDto studentsResponseDto);

    public abstract StudentDto map(StudentRequest studentRequest);

    public abstract StudentCourseDto map(StudentCourseRequest studentCourseRequest);

    public abstract StudentWithCourses toStudentWithCourses(StudentWithCoursesDto dto);

    public abstract List<StudentWithCourses> toStudentWithCoursesList(List<StudentWithCoursesDto> dtoList);

    public abstract Course toCourse(CourseDto dto);
}
