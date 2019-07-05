
package com.leon.payeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Saiful Leon
 */

@Controller
public class PagesController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showContext() {
        return "index";
    }
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showDashboard() {
        return "dashboard";
    }
    
}
