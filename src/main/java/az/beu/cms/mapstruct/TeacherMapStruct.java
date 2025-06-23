package az.beu.cms.mapstruct;

import az.beu.cms.model.teacher.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class TeacherMapStruct {

    public abstract TeacherResponseDto map(TeacherDto teacherDto);

    @Mapping(target = "teachers", source = "teacherDtos")
    public abstract TeachersResponse map(TeachersResponseDto teachersResponseDto);

    public abstract TeacherDto map(TeacherRequest teacherRequest);
}
