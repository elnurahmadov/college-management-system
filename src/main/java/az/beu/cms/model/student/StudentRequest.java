package az.beu.cms.model.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private String name;
    private String surname;
    private String middleName;
    private String email;
    @NonNull
    private String username;
    private String departmentCode;
    private String classNumber;
    private String state;
}
