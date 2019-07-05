
package com.leon.payeasy.controller;

import com.leon.payeasy.model.Basicsalary;
import com.leon.payeasy.service.BasicsalaryService;
import com.leon.payeasy.service.BasicyearService;
import com.leon.payeasy.service.JobtitleService;
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
public class BasicsalaryController {
    @Autowired
    BasicsalaryService bscss;
    @Autowired
    BasicyearService bs;
    @Autowired
    JobtitleService js;
    
    
    @RequestMapping("/basicsalary")
    public ModelAndView showBasicsalarys() {
        String basicsalaryList = bscss.viewBasicsalaryList();
        String basicyearList = bs.viewBasicyearList() ;
        String jobtitleList = js.viewJobtitleList();
        ModelAndView mv = new ModelAndView("basicsalary", "basicsalaryMA", new Basicsalary());
        mv.addObject("basicsalaryList", basicsalaryList);
        mv.addObject("basicyearList", basicyearList);
        mv.addObject("jobtitleList", jobtitleList);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/addingBasicsalary", params = "AddBasicsalary")
    public String addBasicsalary(@ModelAttribute("basicsalaryMA") Basicsalary bscsl) {
        bscss.insertBasicsalary(bscsl);
        return "redirect:/basicsalary";
    }

    @RequestMapping(value = "/addingBasicsalary", params = "EditBasicsalary")
    public String editBasicsalary(@ModelAttribute("basicsalaryMA") Basicsalary bscsl) {
        bscss.updateBasicsalary(bscsl);
        return "redirect:/basicsalary";
    }

    @RequestMapping("removebscsl/{Id}")
    public String removeBasicsalary(@PathVariable("Id") int bscslId) {
        bscss.deleteBasicsalary(bscslId);
        return "redirect:/basicsalary";
    }

    @RequestMapping("/editbscslbutton")
    public ModelAndView passingoneBasicsalary(@RequestParam("getbscslid") int bscslId) {
        Basicsalary singleBscsl = bscss.viewBasicsalary(bscslId);
        String bscslgsonlist = bscss.viewBasicsalaryList();
        String basicyearList = bs.viewBasicyearList() ;
        String jobtitleList = js.viewJobtitleList();
        ModelAndView mv = new ModelAndView("basicsalary", "basicsalaryMA", singleBscsl);
        mv.addObject("basicsalaryList", bscslgsonlist);
        mv.addObject("basicyearList", basicyearList);
        mv.addObject("jobtitleList", jobtitleList);
        mv.addObject("prevBasicyear", singleBscsl.getBasicyearvalue());
        mv.addObject("prevJobtitle", singleBscsl.getJobtitlename());
        mv.addObject("check", "false");
        return mv;
    }
    
    

    

}
