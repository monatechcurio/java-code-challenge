package com.mindex.challenge.data;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

public class Compensation {

    private String id;
    private Employee employee;

    private Integer salary;

    private Date effectiveDate;

    public Compensation(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
