
package com.leon.payeasy.service;


import com.leon.payeasy.model.Paydeduction;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface PaydeductionService {
    public String insertPaydeduction(ArrayList<Paydeduction> paydeductions);

    
}
