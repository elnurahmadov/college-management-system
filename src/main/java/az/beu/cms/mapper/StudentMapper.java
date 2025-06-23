package az.beu.cms.mapper;

import az.beu.cms.model.student.StudentCourseDto;
import az.beu.cms.model.student.StudentDto;
import az.beu.cms.model.student.StudentRequest;
import az.beu.cms.model.student.StudentWithCoursesDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
public interface StudentMapper {

    void addStudent(@Param("dto") StudentDto studentDto);

    StudentDto getStudentByUsername(@Param("username") String username);

    List<StudentDto> getStudents();

    List<StudentDto> getStudentsByCriteria(@Param("request") StudentRequest studentRequest);

    void deleteStudentByUsername(@Param("username") String username);

    void registerStudentToCourse(@Param("dto") StudentCourseDto studentCourseDto);

    List<StudentWithCoursesDto> getStudentsByCourseId(@Param("courseId") UUID courseId);
}
