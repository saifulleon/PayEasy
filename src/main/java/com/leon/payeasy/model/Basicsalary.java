
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
public class Basicsalary implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int basicsalaryid;
    @Column
    private double basicsalaryamount;
    @Column
    private String jobtitlename;
    @Column
    private String basicyearvalue;
    
    
    // Getters and Setters

    public int getBasicsalaryid() {
        return basicsalaryid;
    }

    public void setBasicsalaryid(int basicsalaryid) {
        this.basicsalaryid = basicsalaryid;
    }

    public double getBasicsalaryamount() {
        return basicsalaryamount;
    }

    public void setBasicsalaryamount(double basicsalaryamount) {
        this.basicsalaryamount = basicsalaryamount;
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

    @Override
    public String toString() {
        return "Basicsalary{" + "basicsalaryid=" + basicsalaryid + ", basicsalaryamount=" + basicsalaryamount + ", jobtitlename=" + jobtitlename + ", basicyearvalue=" + basicyearvalue + '}';
    }
    
    
    
    
    
    
}

