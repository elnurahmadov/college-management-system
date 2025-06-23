package az.beu.cms.service.impl;

import az.beu.cms.mapper.DepartmentMapper;
import az.beu.cms.mapstruct.DepartmentMapStruct;
import az.beu.cms.model.department.DepartmentDto;
import az.beu.cms.model.department.DepartmentRequest;
import az.beu.cms.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentMapStruct departmentMapStruct;
    private DepartmentMapper departmentMapper;

    @Override
    public void addDepartment(DepartmentRequest departmentRequest) {
        DepartmentDto departmentDto = departmentMapStruct.map(departmentRequest);
        departmentDto.setState("1");
        departmentMapper.addDepartment(departmentDto);
    }

    @Override
    public void deleteDepartment(String code) {
        departmentMapper.deleteDepartment(code);
    }
}
