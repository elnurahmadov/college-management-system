package az.beu.cms.model.teacher;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {

    private String name;
    private String surname;
    private String middleName;
    private String email;
    @NonNull
    private String username;
    private String departmentCode;
    private String state;
}
