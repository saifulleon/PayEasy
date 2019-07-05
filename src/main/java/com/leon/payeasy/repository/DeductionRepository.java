
package com.leon.payeasy.repository;

import com.leon.payeasy.model.Deduction;
import com.leon.payeasy.service.DeductionService;
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
public class DeductionRepository implements DeductionService{
    
    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public String insertDeduction(Deduction deduction) {
        Session session = sessionFactory.getCurrentSession();
        session.save(deduction);
        return null;
    }

    @Override
    public String updateDeduction(Deduction deduction) {
        Session session = sessionFactory.getCurrentSession();
        session.update(deduction);
        return null;
    }

    @Override
    public String deleteDeduction(int deductionid) {
        Session session = sessionFactory.getCurrentSession();
        Deduction deduction = (Deduction) session.get(Deduction.class, deductionid);
        if(null != deduction){
            session.delete(deduction);
        }
        return null;
    }

    @Override
    public String viewDeductionList() {
        Session session = sessionFactory.getCurrentSession();
        List<Deduction> deductionList = session.createQuery("from Deduction").list();
        
        Gson g = new Gson();
        String deductionListJson = g.toJson(deductionList);
        return deductionListJson;
    }

    @Override
    public Deduction viewDeduction(int deductionid) {
        Session session = sessionFactory.getCurrentSession();
        Deduction deduction = (Deduction) session.get(Deduction.class, deductionid);
        return deduction;
    }
    
}
