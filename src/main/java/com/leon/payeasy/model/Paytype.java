
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
public class Paytype implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paytypeid;
    @Column
    private String paytypename;

    public int getPaytypeid() {
        return paytypeid;
    }

    public void setPaytypeid(int paytypeid) {
        this.paytypeid = paytypeid;
    }

    public String getPaytypename() {
        return paytypename;
    }

    public void setPaytypename(String paytypename) {
        this.paytypename = paytypename;
    }

    
    
    
    
}

