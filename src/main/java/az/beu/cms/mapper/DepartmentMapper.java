package az.beu.cms.mapper;

import az.beu.cms.model.department.DepartmentDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DepartmentMapper {

    void addDepartment(@Param("dto") DepartmentDto departmentDto);

    void deleteDepartment(@Param("code") String code);
}
