package az.beu.cms.model.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {

    private UUID id;
    private String courseName;
    private Integer credits;
    private Integer courseCode;
    private String departmentCode;
    private String state;
}
