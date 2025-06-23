package az.beu.cms.model.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponseDto {

    private UUID id;
    private String name;
    private String surname;
    private String middleName;
    private String email;
    private String username;
    private String departmentCode;
    private String state;

}
