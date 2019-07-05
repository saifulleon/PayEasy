
package com.leon.payeasy.controller;

import com.leon.payeasy.model.AllowanceCartItem;
import com.leon.payeasy.model.AllowanceCartItemAvail;
import com.leon.payeasy.model.Allowancecal;
import com.leon.payeasy.service.AllowancecalService;
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
public class AllowanceCartController {
    @Autowired
    AllowancecalService acls;

    @RequestMapping("/addallowance2cart")
    public String addAllowance2Cart(@RequestParam("getallowanceid") int allowanceid, HttpSession paymentsession) {
        // add from available allowances to added items
        Allowancecal singleAcal = acls.viewAllowancecal(allowanceid);
        
        ArrayList<AllowanceCartItem> allowanceCartTemp = (ArrayList<AllowanceCartItem>) paymentsession.getAttribute("allowanceCart");
        
        AllowanceCartItem allowanceCartItem = new AllowanceCartItem();
        allowanceCartItem.setAllowancecalid(singleAcal.getAllowancecalid());
        allowanceCartItem.setAllowancehead(singleAcal.getAllowancehead());
        allowanceCartItem.setPercent(singleAcal.getPercent());
        allowanceCartItem.setAmount(singleAcal.getAmount());

        allowanceCartTemp.add(allowanceCartItem);
        paymentsession.setAttribute("allowanceCart", allowanceCartTemp);
        
        // remove item from available allowances
        @SuppressWarnings("unchecked")
        ArrayList<AllowanceCartItemAvail> allowanceCartAvailTemp = (ArrayList<AllowanceCartItemAvail>) paymentsession.getAttribute("allowanceCartAvail");
        Iterator<AllowanceCartItemAvail> itrAvail = allowanceCartAvailTemp.iterator();
        while (itrAvail.hasNext()) {
            AllowanceCartItemAvail aciAvail = itrAvail.next();
            if (aciAvail.getAllowancecalid() == allowanceid) {
                allowanceCartAvailTemp.remove(allowanceCartAvailTemp.indexOf(aciAvail));
                break;
            }
        }
        paymentsession.setAttribute("allowanceCartAvail", allowanceCartAvailTemp);
        
        
        return "redirect:/payment";
    }
    
    
    
    
    @RequestMapping("/deleteallowance4rmcart")
    public String removeproductitem(@RequestParam("getallowanceid") int allowanceid, HttpSession paymentsession) {
        // Remove allowance from added items
        @SuppressWarnings("unchecked")
        ArrayList<AllowanceCartItem> allowanceCartTemp = (ArrayList<AllowanceCartItem>) paymentsession.getAttribute("allowanceCart");
        Iterator<AllowanceCartItem> itr = allowanceCartTemp.iterator();
        while (itr.hasNext()) {
            AllowanceCartItem aci = itr.next();
            if (aci.getAllowancecalid() == allowanceid) {
                allowanceCartTemp.remove(allowanceCartTemp.indexOf(aci));
                break;
            }
        }
        paymentsession.setAttribute("allowanceCart", allowanceCartTemp);
        
        //add the removed item back to the available Allowances
        Allowancecal singleAcal = acls.viewAllowancecal(allowanceid);
        
        ArrayList<AllowanceCartItemAvail> allowanceCartAvailTemp = (ArrayList<AllowanceCartItemAvail>) paymentsession.getAttribute("allowanceCartAvail");
        
        AllowanceCartItemAvail allowanceCartItemAvail = new AllowanceCartItemAvail();
        allowanceCartItemAvail.setAllowancecalid(singleAcal.getAllowancecalid());
        allowanceCartItemAvail.setAllowancehead(singleAcal.getAllowancehead());
        allowanceCartItemAvail.setPercent(singleAcal.getPercent());
        allowanceCartItemAvail.setAmount(singleAcal.getAmount());

        allowanceCartAvailTemp.add(allowanceCartItemAvail);
        paymentsession.setAttribute("allowanceCartAvail", allowanceCartAvailTemp);
        
        
        return "redirect:/payment";
    }
    
    
}
