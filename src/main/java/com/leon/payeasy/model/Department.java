
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
public class Department implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int departmentid;
    @Column
    private String departmentname;

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
    
    
    
}

