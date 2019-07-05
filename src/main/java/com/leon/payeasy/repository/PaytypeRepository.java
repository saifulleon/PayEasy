
package com.leon.payeasy.repository;

import com.leon.payeasy.model.Paytype;
import com.leon.payeasy.service.PaytypeService;
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
public class PaytypeRepository implements PaytypeService{
    
    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public String insertPaytype(Paytype paytype) {
        Session session = sessionFactory.getCurrentSession();
        session.save(paytype);
        return null;
    }

    @Override
    public String updatePaytype(Paytype paytype) {
        Session session = sessionFactory.getCurrentSession();
        session.update(paytype);
        return null;
    }

    @Override
    public String deletePaytype(int paytypeid) {
        Session session = sessionFactory.getCurrentSession();
        Paytype paytype = (Paytype) session.get(Paytype.class, paytypeid);
        if(null != paytype){
            session.delete(paytype);
        }
        return null;
    }

    @Override
    public String viewPaytypeList() {
        Session session = sessionFactory.getCurrentSession();
        List<Paytype> paytypeList = session.createQuery("from Paytype").list();
        
        Gson g = new Gson();
        String paytypeListJson = g.toJson(paytypeList);
        return paytypeListJson;
    }

    @Override
    public Paytype viewPaytype(int paytypeid) {
        Session session = sessionFactory.getCurrentSession();
        Paytype paytype = (Paytype) session.get(Paytype.class, paytypeid);
        return paytype;
    }
    
}
