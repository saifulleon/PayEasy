
package com.leon.payeasy.controller;

import com.leon.payeasy.model.Paytype;
import com.leon.payeasy.service.PaytypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Saiful Leon
 */

@Controller
public class PaytypeController {
    @Autowired
    PaytypeService pts;
    
    
    
    @RequestMapping("/paytype")
    public ModelAndView showPaytype() {
        String paytypeList = pts.viewPaytypeList();
        ModelAndView mv = new ModelAndView("paytype", "paytypeMA", new Paytype());
        mv.addObject("paytypeList", paytypeList);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/addingPaytype", params = "AddPaytype")
    public String addPaytype(@ModelAttribute("paytypeMA") Paytype payt) {
        pts.insertPaytype(payt);
        return "redirect:/paytype";
    }

    @RequestMapping(value = "/addingPaytype", params = "EditPaytype")
    public String editPaytype(@ModelAttribute("paytypeMA") Paytype payt) {
        pts.updatePaytype(payt);
        return "redirect:/paytype";
    }

    @RequestMapping("removepayt/{Id}")
    public String removePaytype(@PathVariable("Id") int paytId) {
        pts.deletePaytype(paytId);
        return "redirect:/paytype";
    }

    @RequestMapping("/editpaytbutton")
    public ModelAndView passingonePaytype(@RequestParam("getpaytid") int paytId) {
        Paytype singlePayt = pts.viewPaytype(paytId);
        String paytgsonlist = pts.viewPaytypeList();
        ModelAndView mv = new ModelAndView("paytype", "paytypeMA", singlePayt);
        mv.addObject("paytypeList", paytgsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
    

    

}
