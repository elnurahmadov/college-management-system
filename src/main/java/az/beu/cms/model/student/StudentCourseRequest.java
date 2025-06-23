package az.beu.cms.model.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseRequest {

    @NotNull
    private UUID studentId;
    @NotNull
    private UUID courseId;
}
