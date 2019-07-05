
package com.leon.payeasy.controller;

import com.leon.payeasy.model.Basicyear;
import com.leon.payeasy.service.BasicyearService;
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
public class BasicyearController {
    @Autowired
    BasicyearService bys;
    
    
    
    @RequestMapping("/basicyear")
    public ModelAndView showBasicyears() {
        String basicyearList = bys.viewBasicyearList();
        ModelAndView mv = new ModelAndView("basicyear", "basicyearMA", new Basicyear());
        mv.addObject("basicyearList", basicyearList);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/addingBasicyear", params = "AddBasicyear")
    public String addBasicyear(@ModelAttribute("basicyearMA") Basicyear bsyr) {
        bys.insertBasicyear(bsyr);
        return "redirect:/basicyear";
    }

    @RequestMapping(value = "/addingBasicyear", params = "EditBasicyear")
    public String editBasicyear(@ModelAttribute("basicyearMA") Basicyear bsyr) {
        bys.updateBasicyear(bsyr);
        return "redirect:/basicyear";
    }

    @RequestMapping("removebsyr/{Id}")
    public String removeBasicyear(@PathVariable("Id") int bsyrId) {
        bys.deleteBasicyear(bsyrId);
        return "redirect:/basicyear";
    }

    @RequestMapping("/editbsyrbutton")
    public ModelAndView passingoneBasicyear(@RequestParam("getbsyrid") int bsyrId) {
        Basicyear singleBsyr = bys.viewBasicyear(bsyrId);
        String bsyrgsonlist = bys.viewBasicyearList();
        ModelAndView mv = new ModelAndView("basicyear", "basicyearMA", singleBsyr);
        mv.addObject("basicyearList", bsyrgsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
    

    

}
