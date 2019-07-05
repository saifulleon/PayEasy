
package com.leon.payeasy.service;


import com.leon.payeasy.model.Paytype;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface PaytypeService {
    public String insertPaytype(Paytype paytype);

    public String updatePaytype(Paytype paytype);

    public String deletePaytype(int paytypeid);

    public String viewPaytypeList();

    public Paytype viewPaytype(int paytypeid);
}
