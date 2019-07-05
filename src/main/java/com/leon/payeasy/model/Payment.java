
package com.leon.payeasy.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Saiful Leon
 */

@Entity
public class Payment implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentid;
    @Column
    private String empname;
    @Column
    private String jobtitlename;
    @Column
    private String basicyearvalue;
    @Column
    private double basicsalaryamount;
    @Column
    private String payingmonth;
    @Column
    private String payingyear;
    @Column
    private String paytypename;
    @Column
    private String checkno;
    @Column
    private String bankname;
    @Column
    private double totalallowance;
    @Column
    private double totaldeduction;
    @Column
    private double netsalary;
    
    
    //Getters and Setters

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getJobtitlename() {
        return jobtitlename;
    }

    public void setJobtitlename(String jobtitlename) {
        this.jobtitlename = jobtitlename;
    }

    public String getBasicyearvalue() {
        return basicyearvalue;
    }

    public void setBasicyearvalue(String basicyearvalue) {
        this.basicyearvalue = basicyearvalue;
    }

    public double getBasicsalaryamount() {
        return basicsalaryamount;
    }

    public void setBasicsalaryamount(double basicsalaryamount) {
        this.basicsalaryamount = basicsalaryamount;
    }

    public String getPayingmonth() {
        return payingmonth;
    }

    public void setPayingmonth(String payingmonth) {
        this.payingmonth = payingmonth;
    }

    public String getPayingyear() {
        return payingyear;
    }

    public void setPayingyear(String payingyear) {
        this.payingyear = payingyear;
    }

    public String getPaytypename() {
        return paytypename;
    }

    public void setPaytypename(String paytypename) {
        this.paytypename = paytypename;
    }

    public String getCheckno() {
        return checkno;
    }

    public void setCheckno(String checkno) {
        this.checkno = checkno;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public double getTotalallowance() {
        return totalallowance;
    }

    public void setTotalallowance(double totalallowance) {
        this.totalallowance = totalallowance;
    }

    public double getTotaldeduction() {
        return totaldeduction;
    }

    public void setTotaldeduction(double totaldeduction) {
        this.totaldeduction = totaldeduction;
    }

    public double getNetsalary() {
        return netsalary;
    }

    public void setNetsalary(double netsalary) {
        this.netsalary = netsalary;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentid=" + paymentid + ", empname=" + empname + ", jobtitlename=" + jobtitlename + ", basicyearvalue=" + basicyearvalue + ", basicsalaryamount=" + basicsalaryamount + ", payingmonth=" + payingmonth + ", payingyear=" + payingyear + ", paytypename=" + paytypename + ", checkno=" + checkno + ", bankname=" + bankname + ", totalallowance=" + totalallowance + ", totaldeduction=" + totaldeduction + ", netsalary=" + netsalary + '}';
    }

    

    

    

    
    
    
}

