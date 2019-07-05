
package com.leon.payeasy.service;


import com.leon.payeasy.model.Employee;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface EmployeeService {
    public String insertEmployee(Employee employee);

    public String updateEmployee(Employee employee);

    public String deleteEmployee(int empid);

    public String viewEmployeeList();

    public Employee viewEmployee(int empid);
}
