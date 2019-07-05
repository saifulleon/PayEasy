
package com.leon.payeasy.repository;

import com.leon.payeasy.model.Department;
import com.leon.payeasy.service.DepartmentService;
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
public class DepartmentRepository implements DepartmentService{
    
    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public String insertDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.save(department);
        return null;
    }

    @Override
    public String updateDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.update(department);
        return null;
    }

    @Override
    public String deleteDepartment(int departmentid) {
        Session session = sessionFactory.getCurrentSession();
        Department department = (Department) session.get(Department.class, departmentid);
        if(null != department){
            session.delete(department);
        }
        return null;
    }

    @Override
    public String viewDepartmentList() {
        Session session = sessionFactory.getCurrentSession();
        List<Department> departmentList = session.createQuery("from Department").list();
        
        Gson g = new Gson();
        String departmentListJson = g.toJson(departmentList);
        return departmentListJson;
    }

    @Override
    public Department viewDepartment(int departmentid) {
        Session session = sessionFactory.getCurrentSession();
        Department department = (Department) session.get(Department.class, departmentid);
        return department;
    }
    
}
