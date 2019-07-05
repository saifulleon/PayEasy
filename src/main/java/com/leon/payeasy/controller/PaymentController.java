package com.leon.payeasy.controller;

import com.google.gson.Gson;
import com.leon.payeasy.model.AllowanceCartItem;
import com.leon.payeasy.model.AllowanceCartItemAvail;
import com.leon.payeasy.model.Allowancecal;
import com.leon.payeasy.model.Basicsalary;
import com.leon.payeasy.model.Basicyear;
import com.leon.payeasy.model.DeductionCartItem;
import com.leon.payeasy.model.DeductionCartItemAvail;
import com.leon.payeasy.model.Deductioncal;
import com.leon.payeasy.model.Employee;
import com.leon.payeasy.model.Payallowance;
import com.leon.payeasy.model.Paydeduction;
import com.leon.payeasy.model.Payment;
import com.leon.payeasy.service.AllowancecalService;
import com.leon.payeasy.service.BasicsalaryService;
import com.leon.payeasy.service.BasicyearService;
import com.leon.payeasy.service.DeductioncalService;
import com.leon.payeasy.service.EmployeeService;
import com.leon.payeasy.service.DepartmentService;
import com.leon.payeasy.service.EmptypeService;
import com.leon.payeasy.service.JobtitleService;
import com.leon.payeasy.service.PayallowanceService;
import com.leon.payeasy.service.PaydeductionService;
import com.leon.payeasy.service.PaymentService;
import com.leon.payeasy.service.PaytypeService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Saiful Leon
 */
@Controller
public class PaymentController {

    @Autowired
    EmployeeService es;
    @Autowired
    PaytypeService pts;
    @Autowired
    BasicsalaryService bss;
    @Autowired
    BasicyearService bs;
    @Autowired
    AllowancecalService acls;
    @Autowired
    DeductioncalService dcls;
    @Autowired
    PaymentService pms;
    @Autowired
    PayallowanceService pas;
    @Autowired
    PaydeductionService pds;
    
    

    @RequestMapping("/employee2pay")
    public ModelAndView showEmployees() {
        String employeeList = es.viewEmployeeList();

        ModelAndView mv = new ModelAndView("employee2pay");
        mv.addObject("employeeList", employeeList);
        return mv;
    }

    @RequestMapping("/paynowbutton")
    public ModelAndView passingoneEmployee(@RequestParam("getempid") int empId, HttpSession paymentsession) {
        Employee singleEmp = es.viewEmployee(empId);
        String basicyearList = bs.viewBasicyearList();

        paymentsession.setAttribute("basicyear", new Basicyear());
        paymentsession.setAttribute("singleEmp2pay", singleEmp);
        paymentsession.setAttribute("allowanceCart", new ArrayList<>());
        paymentsession.setAttribute("allowanceCartAvail", new ArrayList<>());
        paymentsession.setAttribute("deductionCart", new ArrayList<>());
        paymentsession.setAttribute("deductionCartAvail", new ArrayList<>());
        paymentsession.setAttribute("acartempty", "true");
        paymentsession.setAttribute("dcartempty", "true");
        
        ModelAndView mv = new ModelAndView("selectbasicyear");
        mv.addObject("basicyearList", basicyearList);

        return mv;
    }
    
    
    @RequestMapping(value = "/processBasicyear", method = RequestMethod.POST)
    public String processBasicyear(HttpServletRequest request, HttpSession paymentsession){
        int basicyearSelectedid = Integer.parseInt(request.getParameter("basicyear"));
        Basicyear basicyearSelected = bs.viewBasicyear(basicyearSelectedid);
        paymentsession.setAttribute("basicyear", basicyearSelected);
        
        Employee emp = (Employee) paymentsession.getAttribute("singleEmp2pay");
        Basicyear byr = (Basicyear) paymentsession.getAttribute("basicyear");
        String jobtitle = emp.getJobtitlename();
        String byrvalue = byr.getBasicyearvalue();
        
        List<Allowancecal> AllowancecalByEmp = acls.viewAllowancecalByEmployee(jobtitle, byrvalue);
        List<AllowanceCartItemAvail> allowanceCartAvailTemp = new ArrayList<>();
        Iterator<Allowancecal> itr = AllowancecalByEmp.iterator();
            while(itr.hasNext()){
                Allowancecal acal = itr.next();
                AllowanceCartItemAvail allowanceCartItemAvail = new AllowanceCartItemAvail();
                allowanceCartItemAvail.setAllowancecalid(acal.getAllowancecalid());
                allowanceCartItemAvail.setAllowancehead(acal.getAllowancehead());
                allowanceCartItemAvail.setPercent(acal.getPercent());
                allowanceCartItemAvail.setAmount(acal.getAmount());
                    
                allowanceCartAvailTemp.add(allowanceCartItemAvail);    
            }
        paymentsession.setAttribute("allowanceCartAvail", allowanceCartAvailTemp);
        
        List<Deductioncal> DeductioncalByEmp = dcls.viewDeductioncalByEmployee(jobtitle, byrvalue);
        List<DeductionCartItemAvail> deductionCartAvailTemp = new ArrayList<>();
        Iterator<Deductioncal> itr2 = DeductioncalByEmp.iterator();
            while(itr2.hasNext()){
                Deductioncal dcal = itr2.next();
                DeductionCartItemAvail deductionCartItemAvail = new DeductionCartItemAvail();
                deductionCartItemAvail.setDeductioncalid(dcal.getDeductioncalid());
                deductionCartItemAvail.setDeductionhead(dcal.getDeductionhead());
                deductionCartItemAvail.setPercent(dcal.getPercent());
                deductionCartItemAvail.setAmount(dcal.getAmount());
                    
                deductionCartAvailTemp.add(deductionCartItemAvail);    
            }
        paymentsession.setAttribute("deductionCartAvail", deductionCartAvailTemp);
        
        
        
        return "redirect:/payment";
    }
    

    @RequestMapping("/payment")
    public ModelAndView showPaymentPage(HttpSession paymentsession) {
        Gson g = new Gson();
        
        Employee emp = (Employee) paymentsession.getAttribute("singleEmp2pay");
        Basicyear byr = (Basicyear) paymentsession.getAttribute("basicyear");
        String jobtitle = emp.getJobtitlename();
        String byrvalue = byr.getBasicyearvalue();
        Basicsalary BasicsalaryByEmployee = bss.viewBasicsalaryByEmployee(jobtitle, byrvalue);
        String BasicsalaryByEmployeeGson = g.toJson(BasicsalaryByEmployee);
        
        String paytypeList = pts.viewPaytypeList();

        ModelAndView mv = new ModelAndView("payment", "paymentMA", new Payment());
        mv.addObject("BasicsalaryByEmployeeGson", BasicsalaryByEmployeeGson);
        mv.addObject("paytypeList", paytypeList);
        
        // Allowance carts
        ArrayList<AllowanceCartItem> acart = (ArrayList<AllowanceCartItem>) paymentsession.getAttribute("allowanceCart");
        if (acart.isEmpty()) {
            paymentsession.setAttribute("acartempty", "true");
        } else {
            String acartgson = g.toJson(acart);
            mv.addObject("acartgson", acartgson);
            paymentsession.setAttribute("acartempty", "false");
        }
        
        
        ArrayList<AllowanceCartItemAvail> acartavail = (ArrayList<AllowanceCartItemAvail>) paymentsession.getAttribute("allowanceCartAvail");
        if (acartavail.isEmpty()) {
            paymentsession.setAttribute("acartavailempty", "true");
        } else {
            String acartvailgson = g.toJson(acartavail);
            mv.addObject("acartavailgson", acartvailgson);
            paymentsession.setAttribute("acartavailempty", "false");
        }
        
        // Deduction carts
        ArrayList<DeductionCartItem> dcart = (ArrayList<DeductionCartItem>) paymentsession.getAttribute("deductionCart");
        if (dcart.isEmpty()) {
            paymentsession.setAttribute("dcartempty", "true");
        } else {
            String dcartgson = g.toJson(dcart);
            mv.addObject("dcartgson", dcartgson);
            paymentsession.setAttribute("dcartempty", "false");
        }
        
        
        ArrayList<DeductionCartItemAvail> dcartavail = (ArrayList<DeductionCartItemAvail>) paymentsession.getAttribute("deductionCartAvail");
        if (dcartavail.isEmpty()) {
            paymentsession.setAttribute("dcartavailempty", "true");
        } else {
            String dcartvailgson = g.toJson(dcartavail);
            mv.addObject("dcartavailgson", dcartvailgson);
            paymentsession.setAttribute("dcartavailempty", "false");
        }

        
        return mv;
    }

    
    @RequestMapping("/processPayment")
    public ModelAndView processPayment(@ModelAttribute("paymentMA") Payment payment, HttpSession paymentsession) {
        String statusOfPayment = pms.insertPayment(payment);
        int payid = payment.getPaymentid();
        paymentsession.setAttribute("payid", payid);
        
        //insert payallowance
        ArrayList<AllowanceCartItem> allowanceCartTemp = (ArrayList<AllowanceCartItem>) paymentsession.getAttribute("allowanceCart");
        ArrayList<Payallowance> payallowances = new ArrayList<>();
        for(AllowanceCartItem allowanceCartItem : allowanceCartTemp){
            Payallowance payallowance = new Payallowance();
            payallowance.setPaymentid(payment.getPaymentid());
            payallowance.setAllowancehead(allowanceCartItem.getAllowancehead());
            payallowance.setAmount(allowanceCartItem.getAmount());
            payallowances.add(payallowance);
        }
        pas.insertPayallowance(payallowances);
        
        //insert paydeduction
        ArrayList<DeductionCartItem> deductionCartTemp = (ArrayList<DeductionCartItem>) paymentsession.getAttribute("deductionCart");
        ArrayList<Paydeduction> paydeductions = new ArrayList<>();
        for(DeductionCartItem deductionCartItem : deductionCartTemp){
            Paydeduction paydeduction = new Paydeduction();
            paydeduction.setPaymentid(payment.getPaymentid());
            paydeduction.setDeductionhead(deductionCartItem.getDeductionhead());
            paydeduction.setAmount(deductionCartItem.getAmount());
            paydeductions.add(paydeduction);
        }
        pds.insertPaydeduction(paydeductions);
        

        // where to go next? 
        if(statusOfPayment.equals("paid")){
            Gson g = new Gson();
            String paymentgson = g.toJson(payment);
            
            ModelAndView mv = new ModelAndView("paymentsuccess");
            mv.addObject("paymentgson", paymentgson);
            
            return mv;
        }
        
        ModelAndView mv = new ModelAndView("paymenterror");
        return mv;
        
    }


    
    
}
