
package com.leon.payeasy.service;


import com.leon.payeasy.model.Basicyear;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface BasicyearService {
    public String insertBasicyear(Basicyear basicyear);

    public String updateBasicyear(Basicyear basicyear);

    public String deleteBasicyear(int basicyearid);

    public String viewBasicyearList();

    public Basicyear viewBasicyear(int basicyearid);
    
}
