package io.zipcoder.persistenceapp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    private String firstName;
    private String lastName;
    private String title;
    private int phoneNum;
    private String email;
    private Date hireDate;
    private String manager;
    private int deptNum;

    public Long getEmployeeId() {
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

    public void setPhoneNumber(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getPhoneNumber() {
        return phoneNum;
    }



}
