
package com.leon.payeasy.repository;

import com.leon.payeasy.model.Basicyear;
import com.leon.payeasy.service.BasicyearService;
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
public class BasicyearRepository implements BasicyearService{
    
    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public String insertBasicyear(Basicyear basicyear) {
        Session session = sessionFactory.getCurrentSession();
        session.save(basicyear);
        return null;
    }

    @Override
    public String updateBasicyear(Basicyear basicyear) {
        Session session = sessionFactory.getCurrentSession();
        session.update(basicyear);
        return null;
    }

    @Override
    public String deleteBasicyear(int basicyearid) {
        Session session = sessionFactory.getCurrentSession();
        Basicyear basicyear = (Basicyear) session.get(Basicyear.class, basicyearid);
        if(null != basicyear){
            session.delete(basicyear);
        }
        return null;
    }

    @Override
    public String viewBasicyearList() {
        Session session = sessionFactory.getCurrentSession();
        List<Basicyear> basicyearList = session.createQuery("from Basicyear").list();
        
        Gson g = new Gson();
        String basicyearListJson = g.toJson(basicyearList);
        return basicyearListJson;
    }

    @Override
    public Basicyear viewBasicyear(int basicyearid) {
        Session session = sessionFactory.getCurrentSession();
        Basicyear basicyear = (Basicyear) session.get(Basicyear.class, basicyearid);
        return basicyear;
    }
    
}
