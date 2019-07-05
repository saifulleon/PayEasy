
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
public class Emptype implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int emptypeid;
    @Column
    private String emptypename;

    public int getEmptypeid() {
        return emptypeid;
    }

    public void setEmptypeid(int emptypeid) {
        this.emptypeid = emptypeid;
    }

    public String getEmptypename() {
        return emptypename;
    }

    public void setEmptypename(String emptypename) {
        this.emptypename = emptypename;
    }

    
    
    
    
}

