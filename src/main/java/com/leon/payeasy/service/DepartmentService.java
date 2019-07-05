
package com.leon.payeasy.service;


import com.leon.payeasy.model.Department;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface DepartmentService {
    public String insertDepartment(Department department);

    public String updateDepartment(Department department);

    public String deleteDepartment(int departmentid);

    public String viewDepartmentList();

    public Department viewDepartment(int departmentid);
}
