
package com.leon.payeasy.service;


import com.leon.payeasy.model.Payment;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface PaymentService {
    public String insertPayment(Payment payment);

}
