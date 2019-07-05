
package com.leon.payeasy.model;

/**
 *
 * @author Saiful Leon
 */

public class DeductionCartItemAvail {
    private int deductioncalid;
    private String deductionhead;
    private int percent;
    private double amount;

    public DeductionCartItemAvail(int deductioncalid, String deductionhead, int percent, double amount) {
        this.deductioncalid = deductioncalid;
        this.deductionhead = deductionhead;
        this.percent = percent;
        this.amount = amount;
    }

    public DeductionCartItemAvail() {
    }

    public int getDeductioncalid() {
        return deductioncalid;
    }

    public void setDeductioncalid(int deductioncalid) {
        this.deductioncalid = deductioncalid;
    }

    public String getDeductionhead() {
        return deductionhead;
    }

    public void setDeductionhead(String deductionhead) {
        this.deductionhead = deductionhead;
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

    @Override
    public String toString() {
        return "DeductionCartItemAvail{" + "deductioncalid=" + deductioncalid + ", deductionhead=" + deductionhead + ", percent=" + percent + ", amount=" + amount + '}';
    }

    

    

    
    
    
    
}
