
package com.leon.payeasy.repository;

import com.leon.payeasy.model.Payment;
import com.leon.payeasy.service.PaymentService;
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
public class PaymentRepository implements PaymentService{
    
    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public String insertPayment(Payment payment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(payment);
        return "paid";
    }

    
    
}
