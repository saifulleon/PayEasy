
package com.leon.payeasy.controller;

import com.google.gson.Gson;
import com.leon.payeasy.model.Deductioncal;
import com.leon.payeasy.service.DeductionService;
import com.leon.payeasy.service.DeductioncalService;
import com.leon.payeasy.service.BasicsalaryService;
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
public class DeductioncalController {
    @Autowired
    DeductioncalService dcls;
    @Autowired
    DeductionService dds;
    @Autowired
    BasicsalaryService bss;
    
    
    @RequestMapping("/deductioncal")
    public ModelAndView showDeductioncals() {
        String deductioncalList = dcls.viewDeductioncalList();
        String deductionList = dds.viewDeductionList();
        String basicsalaryList = bss.viewBasicsalaryList();
        ModelAndView mv = new ModelAndView("deductioncal", "deductioncalMA", new Deductioncal());
        mv.addObject("deductioncalList", deductioncalList);
        mv.addObject("deductionList", deductionList);
        mv.addObject("basicsalaryList", basicsalaryList);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/addingDeductioncal", params = "AddDeductioncal")
    public String addDeductioncal(@ModelAttribute("deductioncalMA") Deductioncal dcl) {
        dcls.insertDeductioncal(dcl);
        return "redirect:/deductioncal";
    }

    @RequestMapping(value = "/addingDeductioncal", params = "EditDeductioncal")
    public String editDeductioncal(@ModelAttribute("deductioncalMA") Deductioncal dcl) {
        dcls.updateDeductioncal(dcl);
        return "redirect:/deductioncal";
    }

    @RequestMapping("removedcl/{Id}")
    public String removeDeductioncal(@PathVariable("Id") int dclId) {
        dcls.deleteDeductioncal(dclId);
        return "redirect:/deductioncal";
    }

    @RequestMapping("/editdclbutton")
    public ModelAndView passingoneDeductioncal(@RequestParam("getdclid") int dclId) {
        Deductioncal singleDcl = dcls.viewDeductioncal(dclId);
        Gson g = new Gson();
        String singleDclJson = g.toJson(singleDcl);
        String dclgsonlist = dcls.viewDeductioncalList();
        String deductionList = dds.viewDeductionList();
        String basicsalaryList = bss.viewBasicsalaryList();
        ModelAndView mv = new ModelAndView("deductioncal", "deductioncalMA", singleDcl);
        mv.addObject("deductioncalList", dclgsonlist);
        mv.addObject("deductionList", deductionList);
        mv.addObject("basicsalaryList", basicsalaryList);
        mv.addObject("singleDclJson", singleDclJson);
        mv.addObject("check", "false");
        return mv;
    }
    
    

    

}
