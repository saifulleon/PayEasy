
package com.leon.payeasy.repository;

import com.leon.payeasy.model.Allowancecal;
import com.leon.payeasy.service.AllowancecalService;
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
public class AllowancecalRepository implements AllowancecalService{
    
    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public String insertAllowancecal(Allowancecal allowancecal) {
        Session session = sessionFactory.getCurrentSession();
        session.save(allowancecal);
        return null;
    }

    @Override
    public String updateAllowancecal(Allowancecal allowancecal) {
        Session session = sessionFactory.getCurrentSession();
        session.update(allowancecal);
        return null;
    }

    @Override
    public String deleteAllowancecal(int allowancecalid) {
        Session session = sessionFactory.getCurrentSession();
        Allowancecal allowancecal = (Allowancecal) session.get(Allowancecal.class, allowancecalid);
        if(null != allowancecal){
            session.delete(allowancecal);
        }
        return null;
    }

    @Override
    public String viewAllowancecalList() {
        Session session = sessionFactory.getCurrentSession();
        List<Allowancecal> allowancecalList = session.createQuery("from Allowancecal").list();
        
        Gson g = new Gson();
        String allowancecalListJson = g.toJson(allowancecalList);
        return allowancecalListJson;
    }

    @Override
    public Allowancecal viewAllowancecal(int allowancecalid) {
        Session session = sessionFactory.getCurrentSession();
        Allowancecal allowancecal = (Allowancecal) session.get(Allowancecal.class, allowancecalid);
        return allowancecal;
    }

    @Override
    public List<Allowancecal> viewAllowancecalByEmployee(String jobtitle, String basicyearvalue) {
        Session session = sessionFactory.getCurrentSession();
        
        String hql = "SELECT x from Allowancecal x WHERE x.jobtitlename=:jt AND x.basicyearvalue=:byearv";
        Query query = session.createQuery(hql);
        
        query.setString("jt", jobtitle);
        query.setString("byearv", basicyearvalue);
        
        List<Allowancecal> list = query.list();
        
        return list;
    }

    
    
    
    
    
    
}
