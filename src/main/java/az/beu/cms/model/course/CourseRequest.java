package az.beu.cms.model.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    private String courseName;
    private Integer credits;
    private Integer courseCode;
    private String departmentCode;
    private String state;
}
