package io.zipcoder.persistenceapp.models;

import javax.persistence.*;

@Entity
@Table(name = "depts")
public class Department {

    @Id
    @Column(name = "deptId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptId;

    @Column(name = "deptName")
    private String deptName;

    @Column(name = "deptManager")
    private Employee deptManager;

    public Department() {
        this.deptName = "";
        this.deptManager = null;
    }

    public Department(String deptName, Employee deptManager) {
        this.deptName = deptName;
        this.deptManager = deptManager;
    }

    public Long getDeptId() {
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
