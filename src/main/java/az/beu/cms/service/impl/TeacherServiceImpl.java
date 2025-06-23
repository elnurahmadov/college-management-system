package az.beu.cms.service.impl;

import az.beu.cms.mapper.TeacherMapper;
import az.beu.cms.mapstruct.TeacherMapStruct;
import az.beu.cms.model.teacher.*;
import az.beu.cms.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private TeacherMapper teacherMapper;
    private TeacherMapStruct teacherMapStruct;

    @Override
    public void addTeacher(TeacherRequest teacherRequest) {
        TeacherResponse existing = getTeacherByUsername(teacherRequest.getUsername());
        if (existing != null) {
            throw new RuntimeException("Bu username artıq mövcuddur: " + teacherRequest.getUsername());
        }

        TeacherDto teacherDto = teacherMapStruct.map(teacherRequest);
        teacherDto.setState("1");
        teacherMapper.addTeacher(teacherDto);
    }

    @Override
    public TeacherResponse getTeacherByUsername(String username) {
        TeacherDto teacherDto = teacherMapper.getTeacherByUsername(username);
        TeacherResponseDto teacherResponseDto = teacherMapStruct.map(teacherDto);
        if (teacherResponseDto == null) {
            return null;
        }
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacherResponseDto.getId());
        teacherResponse.setName(teacherResponseDto.getName());
        teacherResponse.setSurname(teacherResponseDto.getSurname());
        teacherResponse.setMiddleName(teacherResponseDto.getMiddleName());
        teacherResponse.setEmail(teacherResponseDto.getEmail());
        teacherResponse.setUsername(teacherResponseDto.getUsername());
        teacherResponse.setDepartmentCode(teacherResponseDto.getDepartmentCode());
        teacherResponse.setState(teacherResponseDto.getState());
        return teacherResponse;
    }

    @Override
    public TeachersResponse getTeachers() {
        List<TeacherDto> teacherDtoList = teacherMapper.getTeachers();

        TeachersResponseDto responseDto = TeachersResponseDto.builder()
                .teacherDtos(teacherDtoList)
                .build();

        return teacherMapStruct.map(responseDto);
    }

    @Override
    public TeachersResponse getTeachersByCriteria(TeacherRequest teacherRequest) {
        List<TeacherDto> teacherDtoList = teacherMapper.getTeachersByCriteria(teacherRequest);

        TeachersResponseDto responseDto = TeachersResponseDto.builder()
                .teacherDtos(teacherDtoList)
                .build();

        return teacherMapStruct.map(responseDto);
    }

    @Override
    public void deleteTeacherByUsername(String username) {
        TeacherResponse existing = getTeacherByUsername(username);
        if (existing == null) {
            throw new RuntimeException("Bu username mövcud deyil: " + username);
        }
        teacherMapper.deleteTeacherByUsername(username);
    }

}
