package az.beu.cms.mapstruct;

import az.beu.cms.model.department.DepartmentDto;
import az.beu.cms.model.department.DepartmentRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DepartmentMapStruct {

    public abstract DepartmentDto map(DepartmentRequest departmentRequest);
}
