package az.beu.cms.service;

import az.beu.cms.model.course.CourseRequest;

public interface CourseService {
    void addCourse(CourseRequest courseRequest);

    void deleteCourse(String code);
}
