package az.beu.cms.mapper;

import az.beu.cms.model.teacher.TeacherDto;
import az.beu.cms.model.teacher.TeacherRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {

    void addTeacher(@Param("dto") TeacherDto teacherDto);

    TeacherDto getTeacherByUsername(@Param("username") String username);

    List<TeacherDto> getTeachers();

    List<TeacherDto> getTeachersByCriteria(@Param("request") TeacherRequest teacherRequest);

    void deleteTeacherByUsername(@Param("username") String username);
}
