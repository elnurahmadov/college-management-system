package az.beu.cms.service.impl;

import az.beu.cms.mapper.StudentMapper;
import az.beu.cms.mapstruct.StudentMapStruct;
import az.beu.cms.model.student.*;
import az.beu.cms.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;
    private StudentMapStruct studentMapStruct;

    @Override
    public void addStudent(StudentRequest studentRequest) {
        StudentResponse existing = getStudentByUsername(studentRequest.getUsername());
        if (existing != null) {
            throw new RuntimeException("Bu username artıq mövcuddur: " + studentRequest.getUsername());
        }

        StudentDto studentDto = studentMapStruct.map(studentRequest);
        studentDto.setState("1");
        studentMapper.addStudent(studentDto);
    }

    @Override
    public StudentResponse getStudentByUsername(String username) {
        StudentDto studentDto = studentMapper.getStudentByUsername(username);
        StudentResponseDto studentResponseDto = studentMapStruct.map(studentDto);
        if (studentResponseDto == null) {
            return null;
        }
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(studentResponseDto.getId());
        studentResponse.setName(studentResponseDto.getName());
        studentResponse.setSurname(studentResponseDto.getSurname());
        studentResponse.setMiddleName(studentResponseDto.getMiddleName());
        studentResponse.setEmail(studentResponseDto.getEmail());
        studentResponse.setUsername(studentResponseDto.getUsername());
        studentResponse.setDepartmentCode(studentResponseDto.getDepartmentCode());
        studentResponse.setState(studentResponseDto.getState());
        return studentResponse;
    }

    @Override
    public StudentsResponse getStudents() {
        List<StudentDto> studentDtoList = studentMapper.getStudents();

        StudentsResponseDto responseDto = StudentsResponseDto.builder()
                .studentDtos(studentDtoList)
                .build();

        return studentMapStruct.map(responseDto);
    }

    @Override
    public StudentsResponse getStudentsByCriteria(StudentRequest studentRequest) {
        List<StudentDto> studentDtoList = studentMapper.getStudentsByCriteria(studentRequest);

        StudentsResponseDto responseDto = StudentsResponseDto.builder()
                .studentDtos(studentDtoList)
                .build();

        return studentMapStruct.map(responseDto);
    }

    @Override
    public void deleteStudentByUsername(String username) {
        StudentResponse existing = getStudentByUsername(username);
        if (existing == null) {
            throw new RuntimeException("Bu username mövcud deyil: " + username);
        }
        studentMapper.deleteStudentByUsername(username);
    }

    @Override
    public void registerStudentToCourse(StudentCourseRequest studentCourseRequest) {
        StudentCourseDto studentCourseDto = studentMapStruct.map(studentCourseRequest);
        studentCourseDto.setRegistrationDate(LocalDateTime.now());
        studentMapper.registerStudentToCourse(studentCourseDto);
    }

    @Override
    public StudentsWithCourses getStudentsByCourseId(UUID courseId) {
        List<StudentWithCoursesDto> dtoList = studentMapper.getStudentsByCourseId(courseId);
        List<StudentWithCourses> studentList = studentMapStruct.toStudentWithCoursesList(dtoList);

        return StudentsWithCourses.builder()
                .studentWithCourses(studentList)
                .build();
    }

}
