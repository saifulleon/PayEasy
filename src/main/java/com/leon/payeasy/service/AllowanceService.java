
package com.leon.payeasy.service;


import com.leon.payeasy.model.Allowance;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface AllowanceService {
    public String insertAllowance(Allowance allowance);

    public String updateAllowance(Allowance allowance);

    public String deleteAllowance(int allowanceid);

    public String viewAllowanceList();

    public Allowance viewAllowance(int allowanceid);
}
