
package com.leon.payeasy.controller;

import com.leon.payeasy.model.Jobtitle;
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
public class JobtitleController {
    @Autowired
    JobtitleService jts;
    
    
    
    @RequestMapping("/jobtitle")
    public ModelAndView showJobtitles() {
        String jobtitleList = jts.viewJobtitleList();
        ModelAndView mv = new ModelAndView("jobtitle", "jobtitleMA", new Jobtitle());
        mv.addObject("jobtitleList", jobtitleList);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/addingJobtitle", params = "AddJobtitle")
    public String addJobtitle(@ModelAttribute("jobtitleMA") Jobtitle jbttl) {
        jts.insertJobtitle(jbttl);
        return "redirect:/jobtitle";
    }

    @RequestMapping(value = "/addingJobtitle", params = "EditJobtitle")
    public String editJobtitle(@ModelAttribute("jobtitleMA") Jobtitle jbttl) {
        jts.updateJobtitle(jbttl);
        return "redirect:/jobtitle";
    }

    @RequestMapping("removejbttl/{Id}")
    public String removeJobtitle(@PathVariable("Id") int jbttlId) {
        jts.deleteJobtitle(jbttlId);
        return "redirect:/jobtitle";
    }

    @RequestMapping("/editjbttlbutton")
    public ModelAndView passingoneJobtitle(@RequestParam("getjbttlid") int jbttlId) {
        Jobtitle singleJbttl = jts.viewJobtitle(jbttlId);
        String jbttlgsonlist = jts.viewJobtitleList();
        ModelAndView mv = new ModelAndView("jobtitle", "jobtitleMA", singleJbttl);
        mv.addObject("jobtitleList", jbttlgsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
    

    

}
