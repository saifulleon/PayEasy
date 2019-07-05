
package com.leon.payeasy.service;


import com.leon.payeasy.model.Deduction;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface DeductionService {
    public String insertDeduction(Deduction deduction);

    public String updateDeduction(Deduction deduction);

    public String deleteDeduction(int deductionid);

    public String viewDeductionList();

    public Deduction viewDeduction(int deductionid);
}
