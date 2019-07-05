
package com.leon.payeasy.controller;

import com.google.gson.Gson;
import com.leon.payeasy.model.Allowancecal;
import com.leon.payeasy.service.AllowanceService;
import com.leon.payeasy.service.AllowancecalService;
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
public class AllowancecalController {
    @Autowired
    AllowancecalService acls;
    @Autowired
    AllowanceService alls;
    @Autowired
    BasicsalaryService bss;
    
    
    @RequestMapping("/allowancecal")
    public ModelAndView showAllowancecals() {
        String allowancecalList = acls.viewAllowancecalList();
        String allowanceList = alls.viewAllowanceList();
        String basicsalaryList = bss.viewBasicsalaryList();
        ModelAndView mv = new ModelAndView("allowancecal", "allowancecalMA", new Allowancecal());
        mv.addObject("allowancecalList", allowancecalList);
        mv.addObject("allowanceList", allowanceList);
        mv.addObject("basicsalaryList", basicsalaryList);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/addingAllowancecal", params = "AddAllowancecal")
    public String addAllowancecal(@ModelAttribute("allowancecalMA") Allowancecal acl) {
        acls.insertAllowancecal(acl);
        return "redirect:/allowancecal";
    }

    @RequestMapping(value = "/addingAllowancecal", params = "EditAllowancecal")
    public String editAllowancecal(@ModelAttribute("allowancecalMA") Allowancecal acl) {
        acls.updateAllowancecal(acl);
        return "redirect:/allowancecal";
    }

    @RequestMapping("removeacl/{Id}")
    public String removeAllowancecal(@PathVariable("Id") int aclId) {
        acls.deleteAllowancecal(aclId);
        return "redirect:/allowancecal";
    }

    @RequestMapping("/editaclbutton")
    public ModelAndView passingoneAllowancecal(@RequestParam("getaclid") int aclId) {
        Allowancecal singleAcl = acls.viewAllowancecal(aclId);
        Gson g = new Gson();
        String singleAclJson = g.toJson(singleAcl);
        String aclgsonlist = acls.viewAllowancecalList();
        String allowanceList = alls.viewAllowanceList();
        String basicsalaryList = bss.viewBasicsalaryList();
        ModelAndView mv = new ModelAndView("allowancecal", "allowancecalMA", singleAcl);
        mv.addObject("allowancecalList", aclgsonlist);
        mv.addObject("allowanceList", allowanceList);
        mv.addObject("basicsalaryList", basicsalaryList);
        mv.addObject("singleAclJson", singleAclJson);
        mv.addObject("check", "false");
        return mv;
    }
    
    

    

}
