package io.zipcoder.persistenceapp.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String title;
    private String phoneNum;
    private String email;
    private Date hireDate;
    private Employee manager;
    private int deptNum;

    public Employee() {
        this.firstName = "";
        this.lastName = "";
        this.title = "";
        this.phoneNum = "";
        this.email = "";
        this.hireDate = null;
        this.manager = null;
        this.deptNum = 0;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = "";
        this.phoneNum = "";
        this.email = "";
        this.hireDate = null;
        this.manager = null;
        this.deptNum = 0;
    }

    public Employee(String firstName, String lastName, String title, String phoneNum, String email, Date hireDate, Employee manager, int deptNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.phoneNum = phoneNum;
        this.email = email;
        this.hireDate = hireDate;
        this.deptNum = deptNum;
    }

}
