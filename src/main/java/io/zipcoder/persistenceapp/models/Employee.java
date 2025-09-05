package io.zipcoder.persistenceapp.models;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    //@Column(name = "firstName")
    private String firstName;

    //@Column(name = "lastName")
    private String lastName;

    //@Column(name = "title")
    private String title;

    //@Column(name = "phoneNum")
    private String phoneNum;

    //@Column(name = "email")
    private String email;

    //@Column(name = "hireDate")
    private Date hireDate;

    //@Column(name = "manager")
    private Employee manager;

    //@Column(name = "deptNum")
    private Long deptNum;

    public Employee() {
        this.firstName = "";
        this.lastName = "";
        this.title = "";
        this.phoneNum = "";
        this.email = "";
        this.hireDate = null;
        this.manager = null;
        this.deptNum = 0L;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = "";
        this.phoneNum = "";
        this.email = "";
        this.hireDate = null;
        this.manager = null;
        this.deptNum = 0L;
    }

    public Employee(String firstName, String lastName, String title, String phoneNum, String email, Date hireDate, Employee manager, Long deptNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.phoneNum = phoneNum;
        this.email = email;
        this.hireDate = hireDate;
        this.manager = manager;
        this.deptNum = deptNum;
    }

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

    public void setDeptNum(Long deptNum) {
        this.deptNum = deptNum;
    }

    public Long getDeptNum() {
        return deptNum;
    }

}
