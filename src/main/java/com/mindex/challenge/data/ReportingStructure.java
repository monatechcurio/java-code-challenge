package com.mindex.challenge.data;

public class ReportingStructure {

    private Employee employee;

    private Integer numberOfReportees;

    public ReportingStructure() {}
    public ReportingStructure (Employee employee, Integer numberOfReportees) {
        this.employee = employee;
        this.numberOfReportees = numberOfReportees;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getNumberOfReportees() {
        return numberOfReportees;
    }

    public void setNumberOfReportees(Integer numberOfReportees) {
        this.numberOfReportees = numberOfReportees;
    }
}
