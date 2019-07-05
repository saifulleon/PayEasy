
package com.leon.payeasy.repository;

import com.leon.payeasy.model.Deductioncal;
import com.leon.payeasy.service.DeductioncalService;
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
public class DeductioncalRepository implements DeductioncalService{
    
    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public String insertDeductioncal(Deductioncal deductioncal) {
        Session session = sessionFactory.getCurrentSession();
        session.save(deductioncal);
        return null;
    }

    @Override
    public String updateDeductioncal(Deductioncal deductioncal) {
        Session session = sessionFactory.getCurrentSession();
        session.update(deductioncal);
        return null;
    }

    @Override
    public String deleteDeductioncal(int deductioncalid) {
        Session session = sessionFactory.getCurrentSession();
        Deductioncal deductioncal = (Deductioncal) session.get(Deductioncal.class, deductioncalid);
        if(null != deductioncal){
            session.delete(deductioncal);
        }
        return null;
    }

    @Override
    public String viewDeductioncalList() {
        Session session = sessionFactory.getCurrentSession();
        List<Deductioncal> deductioncalList = session.createQuery("from Deductioncal").list();
        
        Gson g = new Gson();
        String deductioncalListJson = g.toJson(deductioncalList);
        return deductioncalListJson;
    }

    @Override
    public Deductioncal viewDeductioncal(int deductioncalid) {
        Session session = sessionFactory.getCurrentSession();
        Deductioncal deductioncal = (Deductioncal) session.get(Deductioncal.class, deductioncalid);
        return deductioncal;
    }
    
    
    public List<Deductioncal> viewDeductioncalByEmployee(String jobtitle, String basicyearvalue) {
        Session session = sessionFactory.getCurrentSession();
        
        String hql = "SELECT x from Deductioncal x WHERE x.jobtitlename=:jt AND x.basicyearvalue=:byearv";
        Query query = session.createQuery(hql);
        
        query.setString("jt", jobtitle);
        query.setString("byearv", basicyearvalue);
        
        List<Deductioncal> list = query.list();
        
        return list;
    }
    
    
}
