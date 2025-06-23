package az.beu.cms.mapper;

import az.beu.cms.model.course.CourseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CourseMapper {
    void addCourse(@Param("dto") CourseDto courseDto);

    void deleteCourse(@Param("code") String code);
}
