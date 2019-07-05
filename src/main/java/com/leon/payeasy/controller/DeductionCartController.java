
package com.leon.payeasy.controller;

import com.leon.payeasy.model.DeductionCartItem;
import com.leon.payeasy.model.DeductionCartItemAvail;
import com.leon.payeasy.model.Deductioncal;
import com.leon.payeasy.service.DeductioncalService;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Saiful Leon
 */

@Controller
public class DeductionCartController {
    @Autowired
    DeductioncalService dcls;

    @RequestMapping("/adddeduction2cart")
    public String addDeduction2Cart(@RequestParam("getdeductionid") int deductionid, HttpSession paymentsession) {
        // add from available deductions to added items
        Deductioncal singleDcal = dcls.viewDeductioncal(deductionid);
        
        ArrayList<DeductionCartItem> deductionCartTemp = (ArrayList<DeductionCartItem>) paymentsession.getAttribute("deductionCart");
        
        DeductionCartItem deductionCartItem = new DeductionCartItem();
        deductionCartItem.setDeductioncalid(singleDcal.getDeductioncalid());
        deductionCartItem.setDeductionhead(singleDcal.getDeductionhead());
        deductionCartItem.setPercent(singleDcal.getPercent());
        deductionCartItem.setAmount(singleDcal.getAmount());

        deductionCartTemp.add(deductionCartItem);
        paymentsession.setAttribute("deductionCart", deductionCartTemp);
        
        // remove item from available deductions
        @SuppressWarnings("unchecked")
        ArrayList<DeductionCartItemAvail> deductionCartAvailTemp = (ArrayList<DeductionCartItemAvail>) paymentsession.getAttribute("deductionCartAvail");
        Iterator<DeductionCartItemAvail> itrAvail = deductionCartAvailTemp.iterator();
        while (itrAvail.hasNext()) {
            DeductionCartItemAvail dciAvail = itrAvail.next();
            if (dciAvail.getDeductioncalid() == deductionid) {
                deductionCartAvailTemp.remove(deductionCartAvailTemp.indexOf(dciAvail));
                break;
            }
        }
        paymentsession.setAttribute("deductionCartAvail", deductionCartAvailTemp);
        
        
        return "redirect:/payment";
    }
    
    
    
    
    @RequestMapping("/deletededuction4rmcart")
    public String removeproductitem(@RequestParam("getdeductionid") int deductionid, HttpSession paymentsession) {
        // Remove deduction from added items
        @SuppressWarnings("unchecked")
        ArrayList<DeductionCartItem> deductionCartTemp = (ArrayList<DeductionCartItem>) paymentsession.getAttribute("deductionCart");
        Iterator<DeductionCartItem> itr = deductionCartTemp.iterator();
        while (itr.hasNext()) {
            DeductionCartItem dci = itr.next();
            if (dci.getDeductioncalid() == deductionid) {
                deductionCartTemp.remove(deductionCartTemp.indexOf(dci));
                break;
            }
        }
        paymentsession.setAttribute("deductionCart", deductionCartTemp);
        
        //add the removed item back to the available Deductions
        Deductioncal singleDcal = dcls.viewDeductioncal(deductionid);
        
        ArrayList<DeductionCartItemAvail> deductionCartAvailTemp = (ArrayList<DeductionCartItemAvail>) paymentsession.getAttribute("deductionCartAvail");
        
        DeductionCartItemAvail deductionCartItemAvail = new DeductionCartItemAvail();
        deductionCartItemAvail.setDeductioncalid(singleDcal.getDeductioncalid());
        deductionCartItemAvail.setDeductionhead(singleDcal.getDeductionhead());
        deductionCartItemAvail.setPercent(singleDcal.getPercent());
        deductionCartItemAvail.setAmount(singleDcal.getAmount());

        deductionCartAvailTemp.add(deductionCartItemAvail);
        paymentsession.setAttribute("deductionCartAvail", deductionCartAvailTemp);
        
        
        return "redirect:/payment";
    }
    
    
}
