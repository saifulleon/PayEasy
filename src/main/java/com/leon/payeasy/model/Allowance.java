
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
public class Allowance implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int allowanceid;
    @Column
    private String allowancehead;

    public int getAllowanceid() {
        return allowanceid;
    }

    public void setAllowanceid(int allowanceid) {
        this.allowanceid = allowanceid;
    }

    public String getAllowancehead() {
        return allowancehead;
    }

    public void setAllowancehead(String allowancehead) {
        this.allowancehead = allowancehead;
    }

    
    
    
    
}

