package az.beu.cms.service.impl;

import az.beu.cms.mapper.CourseMapper;
import az.beu.cms.mapstruct.CourseMapStruct;
import az.beu.cms.model.course.CourseDto;
import az.beu.cms.model.course.CourseRequest;
import az.beu.cms.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private CourseMapStruct courseMapStruct;
    private CourseMapper courseMapper;

    @Override
    public void addCourse(CourseRequest courseRequest) {
        CourseDto courseDto = courseMapStruct.map(courseRequest);
        courseDto.setState("1");
        courseMapper.addCourse(courseDto);
    }

    @Override
    public void deleteCourse(String code) {
        courseMapper.deleteCourse(code);
    }
}
