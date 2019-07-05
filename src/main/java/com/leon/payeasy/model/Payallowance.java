
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
public class Payallowance implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int payallowanceid;
    @Column
    private int paymentid;
    @Column
    private String allowancehead;
    @Column
    private double amount;

    public int getPayallowanceid() {
        return payallowanceid;
    }

    public void setPayallowanceid(int payallowanceid) {
        this.payallowanceid = payallowanceid;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getAllowancehead() {
        return allowancehead;
    }

    public void setAllowancehead(String allowancehead) {
        this.allowancehead = allowancehead;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    

    @Override
    public String toString() {
        return "Payallowance{" + "payallowanceid=" + payallowanceid + ", paymentid=" + paymentid + ", allowancehead=" + allowancehead + ", amount=" + amount + '}';
    }

    
    
    
    
}

