
package com.leon.payeasy.controller;

import com.leon.payeasy.model.Employee;
import com.leon.payeasy.service.EmployeeService;
import com.leon.payeasy.service.DepartmentService;
import com.leon.payeasy.service.EmptypeService;
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
public class EmployeeController {
    @Autowired
    EmployeeService es;
    @Autowired
    JobtitleService js;
    @Autowired
    DepartmentService ds;
    @Autowired
    EmptypeService ets;
    
    
    @RequestMapping("/employee")
    public ModelAndView showEmployees() {
        String employeeList = es.viewEmployeeList();
        String jobtitleList = js.viewJobtitleList();
        String departmentList = ds.viewDepartmentList();
        String emptypeList = ets.viewEmptypeList();
        
        ModelAndView mv = new ModelAndView("employee", "employeeMA", new Employee());
        
        mv.addObject("employeeList", employeeList);
        mv.addObject("jobtitleList", jobtitleList);
        mv.addObject("departmentList", departmentList);
        mv.addObject("emptypeList", emptypeList);
        mv.addObject("check", "true");
        return mv;
    }
    
    
    
    @RequestMapping(value = "/addingEmployee", params = "AddEmployee")
    public String addEmployee(@ModelAttribute("employeeMA") Employee emp) {
        es.insertEmployee(emp);
        return "redirect:/employee";
    }

    @RequestMapping(value = "/addingEmployee", params = "EditEmployee")
    public String editEmployee(@ModelAttribute("employeeMA") Employee emp) {
        es.updateEmployee(emp);
        return "redirect:/employee";
    }

    @RequestMapping("removeemp/{Id}")
    public String removeEmployee(@PathVariable("Id") int empId) {
        es.deleteEmployee(empId);
        return "redirect:/employee";
    }

    @RequestMapping("/editempbutton")
    public ModelAndView passingoneEmployee(@RequestParam("getempid") int empId) {
        Employee singleEmp = es.viewEmployee(empId);
        String empgsonlist = es.viewEmployeeList();
        String jobtitleList = js.viewJobtitleList();
        String departmentList = ds.viewDepartmentList();
        String emptypeList = ets.viewEmptypeList();
        
        ModelAndView mv = new ModelAndView("employee", "employeeMA", singleEmp);
        
        mv.addObject("employeeList", empgsonlist);
        mv.addObject("jobtitleList", jobtitleList);
        mv.addObject("departmentList", departmentList);
        mv.addObject("emptypeList", emptypeList);
        mv.addObject("prevJobtitle", singleEmp.getJobtitlename());
        mv.addObject("prevDepartment", singleEmp.getDepartmentname());
        mv.addObject("prevEmptype", singleEmp.getEmptypename());
        mv.addObject("check", "false");
        return mv;
    }
    
    

    

}
