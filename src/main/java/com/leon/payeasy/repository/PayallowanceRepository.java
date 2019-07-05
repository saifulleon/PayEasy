
package com.leon.payeasy.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.leon.payeasy.model.Payallowance;
import com.leon.payeasy.service.PayallowanceService;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Saiful Leon
 */

@Repository
@Transactional
public class PayallowanceRepository implements PayallowanceService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String insertPayallowance(ArrayList<Payallowance> payallowances) {
        Session session = sessionFactory.getCurrentSession();
        
        for(Payallowance payallowance : payallowances){
            session.save(payallowance);
        }
        
        return null;
    }

    

    
    
    
}
