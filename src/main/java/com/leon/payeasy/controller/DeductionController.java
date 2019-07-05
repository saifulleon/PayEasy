
package com.leon.payeasy.controller;

import com.leon.payeasy.model.Deduction;
import com.leon.payeasy.service.DeductionService;
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
public class DeductionController {
    @Autowired
    DeductionService deds;
    
    
    
    @RequestMapping("/deduction")
    public ModelAndView showDeductions() {
        String deductionList = deds.viewDeductionList();
        ModelAndView mv = new ModelAndView("deduction", "deductionMA", new Deduction());
        mv.addObject("deductionList", deductionList);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/addingDeduction", params = "AddDeduction")
    public String addDeduction(@ModelAttribute("deductionMA") Deduction deduc) {
        deds.insertDeduction(deduc);
        return "redirect:/deduction";
    }

    @RequestMapping(value = "/addingDeduction", params = "EditDeduction")
    public String editDeduction(@ModelAttribute("deductionMA") Deduction deduc) {
        deds.updateDeduction(deduc);
        return "redirect:/deduction";
    }

    @RequestMapping("removededuc/{Id}")
    public String removeDeduction(@PathVariable("Id") int deducId) {
        deds.deleteDeduction(deducId);
        return "redirect:/deduction";
    }

    @RequestMapping("/editdeducbutton")
    public ModelAndView passingoneDeduction(@RequestParam("getdeducid") int deducId) {
        Deduction singleDeduc = deds.viewDeduction(deducId);
        String deducgsonlist = deds.viewDeductionList();
        ModelAndView mv = new ModelAndView("deduction", "deductionMA", singleDeduc);
        mv.addObject("deductionList", deducgsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
    

    

}
