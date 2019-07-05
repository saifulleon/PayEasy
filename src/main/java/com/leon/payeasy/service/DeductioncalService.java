
package com.leon.payeasy.service;


import com.leon.payeasy.model.Deductioncal;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface DeductioncalService {
    public String insertDeductioncal(Deductioncal deductioncal);

    public String updateDeductioncal(Deductioncal deductioncal);

    public String deleteDeductioncal(int deductioncalid);

    public String viewDeductioncalList();

    public Deductioncal viewDeductioncal(int deductioncalid);
    
    public List<Deductioncal> viewDeductioncalByEmployee(String jobtitle, String basicyearvalue);
}
