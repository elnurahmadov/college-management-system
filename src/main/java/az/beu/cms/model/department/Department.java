package az.beu.cms.model.department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    private UUID id;
    private String departmentName;
    private String departmentCode;
    private String state;

}
