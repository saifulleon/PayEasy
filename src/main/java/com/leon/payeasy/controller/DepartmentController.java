
package com.leon.payeasy.controller;

import com.leon.payeasy.model.Department;
import com.leon.payeasy.service.DepartmentService;
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
public class DepartmentController {
    @Autowired
    DepartmentService ds;
    
    
    
    @RequestMapping("/department")
    public ModelAndView showDepartments() {
        String departmentList = ds.viewDepartmentList();
        ModelAndView mv = new ModelAndView("department", "departmentMA", new Department());
        mv.addObject("departmentList", departmentList);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/addingDepartment", params = "AddDepartment")
    public String addDepartment(@ModelAttribute("departmentMA") Department dept) {
        ds.insertDepartment(dept);
        return "redirect:/department";
    }

    @RequestMapping(value = "/addingDepartment", params = "EditDepartment")
    public String editDepartment(@ModelAttribute("departmentMA") Department dept) {
        ds.updateDepartment(dept);
        return "redirect:/department";
    }

    @RequestMapping("removedept/{Id}")
    public String removeDepartment(@PathVariable("Id") int deptId) {
        ds.deleteDepartment(deptId);
        return "redirect:/department";
    }

    @RequestMapping("/editdeptbutton")
    public ModelAndView passingoneDepartment(@RequestParam("getdeptid") int deptId) {
        Department singleDept = ds.viewDepartment(deptId);
        String deptgsonlist = ds.viewDepartmentList();
        ModelAndView mv = new ModelAndView("department", "departmentMA", singleDept);
        mv.addObject("departmentList", deptgsonlist);
        mv.addObject("check", "false");
        return mv;
    }
    
    

    

}
