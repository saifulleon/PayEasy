
package com.leon.payeasy.service;


import com.leon.payeasy.model.Basicsalary;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface BasicsalaryService {
    public String insertBasicsalary(Basicsalary basicsalary);

    public String updateBasicsalary(Basicsalary basicsalary);

    public String deleteBasicsalary(int basicsalaryid);

    public String viewBasicsalaryList();

    public Basicsalary viewBasicsalary(int basicsalaryid);
    
    public Basicsalary viewBasicsalaryByEmployee (String jobtitlename, String basicyearvalue);
}
