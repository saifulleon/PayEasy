
package com.leon.payeasy.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.leon.payeasy.model.Paydeduction;
import com.leon.payeasy.service.PaydeductionService;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Saiful Leon
 */

@Repository
@Transactional
public class PaydeductionRepository implements PaydeductionService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertPaydeduction(ArrayList<Paydeduction> paydeductions) {
        Session session = sessionFactory.getCurrentSession();
        
        for(Paydeduction paydeduction : paydeductions){
            session.save(paydeduction);
        }
        
        return null;
    }

    

    
    
    
}
