package az.beu.cms.model.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse {

    private UUID id;
    private UUID studentId;
    private UUID courseId;
    private LocalDateTime registrationDate;
}
