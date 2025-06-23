package az.beu.cms.model.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {

    @NotNull
    private String departmentName;
    @NotNull
    private String departmentCode;
    private String state;

}
