
package com.leon.payeasy.controller;

import com.leon.payeasy.model.Allowance;
import com.leon.payeasy.service.AllowanceService;
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
public class AllowanceController {
    @Autowired
    AllowanceService alls;
    
    
    
    @RequestMapping("/allowance")
    public ModelAndView showAllowances() {
        String allowanceList = alls.viewAllowanceList();
        ModelAndView mv = new ModelAndView("allowance", "allowanceMA", new Allowance());
        mv.addObject("allowanceList", allowanceList);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/addingAllowance", params = "AddAllowance")
    public String addAllowance(@ModelAttribute("allowanceMA") Allowance allow) {
        alls.insertAllowance(allow);
        return "redirect:/allowance";
    }

    @RequestMapping(value = "/addingAllowance", params = "EditAllowance")
    public String editAllowance(@ModelAttribute("allowanceMA") Allowance allow) {
        alls.updateAllowance(allow);
        return "redirect:/allowance";
    }

    @RequestMapping("removeallow/{Id}")
    public String removeAllowance(@PathVariable("Id") int allowId) {
        alls.deleteAllowance(allowId);
        return "redirect:/allowance";
    }

    @RequestMapping("/editallowbutton")
    public ModelAndView passingoneAllowance(@RequestParam("getallowid") int allowId) {
        Allowance singleAllow = alls.viewAllowance(allowId);
        String allowgsonlist = alls.viewAllowanceList();
        ModelAndView mv = new ModelAndView("allowance", "allowanceMA", singleAllow);
        mv.addObject("allowanceList", allowgsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
    

    

}
