package az.beu.cms.mapstruct;

import az.beu.cms.model.course.CourseDto;
import az.beu.cms.model.course.CourseRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CourseMapStruct {

    public abstract CourseDto map(CourseRequest courseRequest);
}
