
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
public class Deduction implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int deductionid;
    @Column
    private String deductionhead;

    public int getDeductionid() {
        return deductionid;
    }

    public void setDeductionid(int deductionid) {
        this.deductionid = deductionid;
    }

    public String getDeductionhead() {
        return deductionhead;
    }

    public void setDeductionhead(String deductionhead) {
        this.deductionhead = deductionhead;
    }

    
    
    
    
}

