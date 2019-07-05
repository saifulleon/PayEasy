
package com.leon.payeasy.service;


import com.leon.payeasy.model.Payallowance;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface PayallowanceService {
    public String insertPayallowance(ArrayList<Payallowance> payallowances);

    
}
