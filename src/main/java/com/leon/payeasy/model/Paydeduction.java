
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
public class Paydeduction implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paydeductionid;
    @Column
    private int paymentid;
    @Column
    private String deductionhead;
    @Column
    private double amount;

    public int getPaydeductionid() {
        return paydeductionid;
    }

    public void setPaydeductionid(int paydeductionid) {
        this.paydeductionid = paydeductionid;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getDeductionhead() {
        return deductionhead;
    }

    public void setDeductionhead(String deductionhead) {
        this.deductionhead = deductionhead;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    

    @Override
    public String toString() {
        return "Paydeduction{" + "paydeductionid=" + paydeductionid + ", paymentid=" + paymentid + ", deductionhead=" + deductionhead + ", amount=" + amount + '}';
    }

    
    
    
    
}

