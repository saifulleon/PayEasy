
package com.leon.payeasy.repository;

import com.leon.payeasy.model.Employee;
import com.leon.payeasy.service.EmployeeService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Saiful Leon
 */

@Repository
@Transactional
public class EmployeeRepository implements EmployeeService{
    
    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public String insertEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
        return null;
    }

    @Override
    public String updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
        return null;
    }

    @Override
    public String deleteEmployee(int empid) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, empid);
        if(null != employee){
            session.delete(employee);
        }
        return null;
    }

    @Override
    public String viewEmployeeList() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();
        
        Gson g = new Gson();
        String employeeListJson = g.toJson(employeeList);
        return employeeListJson;
    }

    @Override
    public Employee viewEmployee(int empid) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, empid);
        return employee;
    }
    
}
