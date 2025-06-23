package az.beu.cms.service;

import az.beu.cms.model.department.DepartmentRequest;

public interface DepartmentService {

    void addDepartment(DepartmentRequest departmentRequest);

    void deleteDepartment(String code);
}
