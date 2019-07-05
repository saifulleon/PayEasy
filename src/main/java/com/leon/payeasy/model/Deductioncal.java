
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
public class Deductioncal implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int deductioncalid;
    @Column
    private String jobtitlename;
    @Column
    private String deductionhead;
    @Column
    private double basicsalaryamount;
    @Column
    private int percent;
    @Column
    private double amount;
    @Column
    private String basicyearvalue;
    
    
    // Getters and Setters

    public int getDeductioncalid() {
        return deductioncalid;
    }

    public void setDeductioncalid(int deductioncalid) {
        this.deductioncalid = deductioncalid;
    }

    public String getJobtitlename() {
        return jobtitlename;
    }

    public void setJobtitlename(String jobtitlename) {
        this.jobtitlename = jobtitlename;
    }

    public String getDeductionhead() {
        return deductionhead;
    }

    public void setDeductionhead(String deductionhead) {
        this.deductionhead = deductionhead;
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
        return "Deductioncal{" + "deductioncalid=" + deductioncalid + ", jobtitlename=" + jobtitlename + ", deductionhead=" + deductionhead + ", basicsalaryamount=" + basicsalaryamount + ", percent=" + percent + ", amount=" + amount + ", basicyearvalue=" + basicyearvalue + '}';
    }

    


    
  
    
    
}

