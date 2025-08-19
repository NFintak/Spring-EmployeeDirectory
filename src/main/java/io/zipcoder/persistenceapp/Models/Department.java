package io.zipcoder.persistenceapp.Models;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int deptId;
    private String deptName;
    private Employee deptManager;

    public Department() {
        this.deptName = "";
        this.deptManager = null;
    }

    public Department(String deptName, Employee manager) {
        this.deptName = deptName;
        this.deptManager = manager;
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

    public void setDeptManager(Employee manager) {
        this.deptManager = manager;
    }

    public Employee getDeptManager() {
        return deptManager;
    }

}
