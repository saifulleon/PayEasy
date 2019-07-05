
package com.leon.payeasy.repository;

import com.leon.payeasy.model.Basicsalary;
import com.leon.payeasy.service.BasicsalaryService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Saiful Leon
 */

@Repository
@Transactional
public class BasicsalaryRepository implements BasicsalaryService{
    
    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public String insertBasicsalary(Basicsalary basicsalary) {
        Session session = sessionFactory.getCurrentSession();
        session.save(basicsalary);
        return null;
    }

    @Override
    public String updateBasicsalary(Basicsalary basicsalary) {
        Session session = sessionFactory.getCurrentSession();
        session.update(basicsalary);
        return null;
    }

    @Override
    public String deleteBasicsalary(int basicsalaryid) {
        Session session = sessionFactory.getCurrentSession();
        Basicsalary basicsalary = (Basicsalary) session.get(Basicsalary.class, basicsalaryid);
        if(null != basicsalary){
            session.delete(basicsalary);
        }
        return null;
    }

    @Override
    public String viewBasicsalaryList() {
        Session session = sessionFactory.getCurrentSession();
        List<Basicsalary> basicsalaryList = session.createQuery("from Basicsalary").list();
        
        Gson g = new Gson();
        String basicsalaryListJson = g.toJson(basicsalaryList);
        return basicsalaryListJson;
    }

    @Override
    public Basicsalary viewBasicsalary(int basicsalaryid) {
        Session session = sessionFactory.getCurrentSession();
        Basicsalary basicsalary = (Basicsalary) session.get(Basicsalary.class, basicsalaryid);
        return basicsalary;
    }

    @Override
    public Basicsalary viewBasicsalaryByEmployee(String jobtitlename, String basicyearvalue) {
        Session session = sessionFactory.getCurrentSession();
        
        String hql = "SELECT x from Basicsalary x WHERE x.jobtitlename=:jt AND x.basicyearvalue=:byearv";
        Query query = session.createQuery(hql);
        
        query.setString("jt", jobtitlename);
        query.setString("byearv", basicyearvalue);
        
        List<Basicsalary> list = query.list();
        if(list.size() == 1){
            return list.get(0);
        } else{
            return null;
        }
    }
    
    
    
    
    
}
