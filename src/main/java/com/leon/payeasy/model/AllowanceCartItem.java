
package com.leon.payeasy.model;

/**
 *
 * @author Saiful Leon
 */

public class AllowanceCartItem {
    private int allowancecalid;
    private String allowancehead;
    private int percent;
    private double amount;

    public AllowanceCartItem(int allowancecalid, String allowancehead, int percent, double amount) {
        this.allowancecalid = allowancecalid;
        this.allowancehead = allowancehead;
        this.percent = percent;
        this.amount = amount;
    }

    public AllowanceCartItem() {
    }

    public int getAllowancecalid() {
        return allowancecalid;
    }

    public void setAllowancecalid(int allowancecalid) {
        this.allowancecalid = allowancecalid;
    }

    public String getAllowancehead() {
        return allowancehead;
    }

    public void setAllowancehead(String allowancehead) {
        this.allowancehead = allowancehead;
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
        return "AllowanceCartItem{" + "allowancecalid=" + allowancecalid + ", allowancehead=" + allowancehead + ", percent=" + percent + ", amount=" + amount + '}';
    }

    

    
    
    
    
}
