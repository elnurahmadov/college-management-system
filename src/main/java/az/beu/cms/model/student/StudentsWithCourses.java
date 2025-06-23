package az.beu.cms.model.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsWithCourses {

    private List<StudentWithCourses> studentWithCourses;
}

