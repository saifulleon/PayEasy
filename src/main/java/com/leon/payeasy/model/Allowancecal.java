
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
public class Allowancecal implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int allowancecalid;
    @Column
    private String jobtitlename;
    @Column
    private String allowancehead;
    @Column
    private double basicsalaryamount;
    @Column
    private int percent;
    @Column
    private double amount;
    @Column
    private String basicyearvalue;
    
    
    // Getters and Setters

    public int getAllowancecalid() {
        return allowancecalid;
    }

    public void setAllowancecalid(int allowancecalid) {
        this.allowancecalid = allowancecalid;
    }

    public String getJobtitlename() {
        return jobtitlename;
    }

    public void setJobtitlename(String jobtitlename) {
        this.jobtitlename = jobtitlename;
    }

    public String getAllowancehead() {
        return allowancehead;
    }

    public void setAllowancehead(String allowancehead) {
        this.allowancehead = allowancehead;
    }

    public double getBasicsalaryamount() {
        return basicsalaryamount;
    }

    public void setBasicsalaryamount(double basicsalaryamount) {
        this.basicsalaryamount = basicsalaryamount;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBasicyearvalue() {
        return basicyearvalue;
    }

    public void setBasicyearvalue(String basicyearvalue) {
        this.basicyearvalue = basicyearvalue;
    }

    @Override
    public String toString() {
        return "Allowancecal{" + "allowancecalid=" + allowancecalid + ", jobtitlename=" + jobtitlename + ", allowancehead=" + allowancehead + ", basicsalaryamount=" + basicsalaryamount + ", percent=" + percent + ", amount=" + amount + ", basicyearvalue=" + basicyearvalue + '}';
    }



  
    
    
}

