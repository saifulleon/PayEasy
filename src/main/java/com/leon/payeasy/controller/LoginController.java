package com.leon.payeasy.controller;

import com.leon.payeasy.service.Userservice;
import com.leon.payeasy.model.User;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

    @Autowired
    Userservice user;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }

    
    
    @RequestMapping(value = "/loginsuccess")
    public String loginsuccess(HttpSession session) {
        String userid = SecurityContextHolder.getContext().getAuthentication().getName();
        User us = user.viewUser(userid);
        
        session.setAttribute("UserLoggedIn", us.getUsername());
        session.setAttribute("UserId", userid);

        return "redirect:/dashboard";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // For multiple Roles : 
    
//    @RequestMapping(value = "/loginsuccess")
//    public String loginsuccess(HttpSession session) {
//        //System.out.println("success..........");
//
//        String userid = SecurityContextHolder.getContext().getAuthentication().getName();
//        User us = user.viewUser(userid);
//        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//        String page = "";
//        for (GrantedAuthority authority : authorities) {
//            if (authority.getAuthority().equals("ROLE_USER")) {
//                session.setAttribute("UserLoggedIn", us.getUsername());
//                session.setAttribute("UserId", userid);
//                page= "redirect:/userprofile"; // userprofile view not created since PayEasy has no other users except admin
//            }
//            else if (authority.getAuthority().equals("ROLE_ADMIN")) {
//                session.setAttribute("UserLoggedIn", us.getUsername());
//                session.setAttribute("UserId", userid);
//                page= "redirect:/employee";
//            }
//            else{
//            page= "redirect:/";
//            }
//        }
//        return page;
//    }
    
    
    
    
}

