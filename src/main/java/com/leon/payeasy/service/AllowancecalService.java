
package com.leon.payeasy.service;


import com.leon.payeasy.model.Allowancecal;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface AllowancecalService {
    public String insertAllowancecal(Allowancecal allowancecal);

    public String updateAllowancecal(Allowancecal allowancecal);

    public String deleteAllowancecal(int allowancecalid);

    public String viewAllowancecalList();

    public Allowancecal viewAllowancecal(int allowancecalid);
    
    public List<Allowancecal> viewAllowancecalByEmployee(String jobtitle, String basicyearvalue);
}
