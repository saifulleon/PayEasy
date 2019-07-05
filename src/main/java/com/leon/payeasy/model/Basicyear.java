
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
public class Basicyear implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int basicyearid;
    @Column
    private String basicyearvalue;

    public int getBasicyearid() {
        return basicyearid;
    }

    public void setBasicyearid(int basicyearid) {
        this.basicyearid = basicyearid;
    }

    public String getBasicyearvalue() {
        return basicyearvalue;
    }

    public void setBasicyearvalue(String basicyearvalue) {
        this.basicyearvalue = basicyearvalue;
    }

    @Override
    public String toString() {
        return "Basicyear{" + "basicyearid=" + basicyearid + ", basicyearvalue=" + basicyearvalue + '}';
    }


    

    
    
    
}

