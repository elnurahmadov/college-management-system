package az.beu.cms.service;

import az.beu.cms.model.teacher.TeacherRequest;
import az.beu.cms.model.teacher.TeacherResponse;
import az.beu.cms.model.teacher.TeachersResponse;

public interface TeacherService {

    void addTeacher(TeacherRequest teacherRequest);

    TeacherResponse getTeacherByUsername(String username);

    TeachersResponse getTeachers();

    TeachersResponse getTeachersByCriteria(TeacherRequest teacherRequest);

    void deleteTeacherByUsername(String username);
}
