package az.beu.cms.controller;

import az.beu.cms.model.department.DepartmentRequest;
import az.beu.cms.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/department")
    public ResponseEntity<Void> addDepartment(@RequestBody DepartmentRequest departmentRequest) {
        departmentService.addDepartment(departmentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String code) {
        departmentService.deleteDepartment(code);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
