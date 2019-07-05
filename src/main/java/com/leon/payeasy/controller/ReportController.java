package com.leon.payeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.leon.payeasy.reportmodel.EmpByIdReport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import com.leon.payeasy.repository.JasperReportDAO;
import javax.servlet.http.HttpSession;
/**
 *
 * @author User
 */
@Controller
public class ReportController {
    
    @RequestMapping(value = "/reportSingleEmp", method = RequestMethod.GET)
    public String loadSurveyPg(
            @ModelAttribute("reportInputForm") EmpByIdReport reportInputForm, Model model) {
        model.addAttribute("reportInputForm", reportInputForm);
        return "reportSingleEmp";
    }
    
    @RequestMapping(value = "/reportSingleEmp", method = RequestMethod.POST)
    public String generateReport(@ModelAttribute("reportInputForm") EmpByIdReport reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "EmpById";
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            int empid = reportInputForm.getEmpid();
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("empid", empid);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
    
    
    // payslip report
    @RequestMapping(value = "/reportPayslip", method = RequestMethod.GET)
    public String generateReport(HttpServletRequest request,HttpServletResponse response,HttpSession paymentsession) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "payslip";
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            int payid = (int) paymentsession.getAttribute("payid");
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("payid", payid);
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn); 

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }

        return null;
    }
    
}
