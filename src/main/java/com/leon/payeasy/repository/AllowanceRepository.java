
package com.leon.payeasy.repository;

import com.leon.payeasy.model.Allowance;
import com.leon.payeasy.service.AllowanceService;
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
public class AllowanceRepository implements AllowanceService{
    
    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public String insertAllowance(Allowance allowance) {
        Session session = sessionFactory.getCurrentSession();
        session.save(allowance);
        return null;
    }

    @Override
    public String updateAllowance(Allowance allowance) {
        Session session = sessionFactory.getCurrentSession();
        session.update(allowance);
        return null;
    }

    @Override
    public String deleteAllowance(int allowanceid) {
        Session session = sessionFactory.getCurrentSession();
        Allowance allowance = (Allowance) session.get(Allowance.class, allowanceid);
        if(null != allowance){
            session.delete(allowance);
        }
        return null;
    }

    @Override
    public String viewAllowanceList() {
        Session session = sessionFactory.getCurrentSession();
        List<Allowance> allowanceList = session.createQuery("from Allowance").list();
        
        Gson g = new Gson();
        String allowanceListJson = g.toJson(allowanceList);
        return allowanceListJson;
    }

    @Override
    public Allowance viewAllowance(int allowanceid) {
        Session session = sessionFactory.getCurrentSession();
        Allowance allowance = (Allowance) session.get(Allowance.class, allowanceid);
        return allowance;
    }
    
}
