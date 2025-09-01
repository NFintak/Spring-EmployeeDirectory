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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Employee getManager() {
        return manager;
    }

    public void setDeptNum(int deptNum) {
        this.deptNum = deptNum;
    }

    public int getDeptNum() {
        return deptNum;
    }

}
