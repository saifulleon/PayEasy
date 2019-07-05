
package com.leon.payeasy.controller;

import com.leon.payeasy.model.Emptype;
import com.leon.payeasy.service.EmptypeService;
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
public class EmptypeController {
    @Autowired
    EmptypeService ets;
    
    
    
    @RequestMapping("/emptype")
    public ModelAndView showEmptype() {
        String emptypeList = ets.viewEmptypeList();
        ModelAndView mv = new ModelAndView("emptype", "emptypeMA", new Emptype());
        mv.addObject("emptypeList", emptypeList);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/addingEmptype", params = "AddEmptype")
    public String addEmptype(@ModelAttribute("emptypeMA") Emptype empt) {
        ets.insertEmptype(empt);
        return "redirect:/emptype";
    }

    @RequestMapping(value = "/addingEmptype", params = "EditEmptype")
    public String editEmptype(@ModelAttribute("emptypeMA") Emptype empt) {
        ets.updateEmptype(empt);
        return "redirect:/emptype";
    }

    @RequestMapping("removeempt/{Id}")
    public String removeEmptype(@PathVariable("Id") int emptId) {
        ets.deleteEmptype(emptId);
        return "redirect:/emptype";
    }

    @RequestMapping("/editemptbutton")
    public ModelAndView passingoneEmptype(@RequestParam("getemptid") int emptId) {
        Emptype singleEmpt = ets.viewEmptype(emptId);
        String emptgsonlist = ets.viewEmptypeList();
        ModelAndView mv = new ModelAndView("emptype", "emptypeMA", singleEmpt);
        mv.addObject("emptypeList", emptgsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
    

    

}
