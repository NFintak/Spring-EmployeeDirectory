package io.zipcoder.persistenceapp.models;

import javax.persistence.*;
import io.zipcoder.persistenceapp.models.Employee;

@Entity
public class Department {

    private int deptId;

    private String deptName;
    private Employee deptManager;

    public Department() {
        this.deptName = "";
        this.deptManager = null;
    }

    public Department(String deptName, Employee deptManager) {
        this.deptName = deptName;
        this.deptManager = deptManager;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptManager(Employee deptManager) {
        this.deptManager = deptManager;
    }

    public Employee getDeptManager() {
        return deptManager;
    }

}
