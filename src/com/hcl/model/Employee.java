package com.hcl.model;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EmployeeHCL")
public class Employee {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="hclemp_seq_gen")
	@SequenceGenerator(name="hclemp_seq_gen", allocationSize=1, sequenceName="hclemp_seq_gen")
	private int employeeNo;
	
	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date employeeDOB;
	
	@Column(name = "last_login")
	@Temporal(TemporalType.TIMESTAMP)
	private Date employeeLastLogin;
	
	@Column(name="name")
	private String employeeName;
	
	@Column(name="city")
	private String employeeCity;
	
	@Column(name="salary")
	private long employeeSalary;

	
	// Constructor
	public Employee() {}
	public Employee(Date employeeDOB, Date employeeLastLogin, String employeeName, String employeeCity,
			long employeeSalary) {
		super();
		this.employeeDOB = employeeDOB;
		this.employeeLastLogin = employeeLastLogin;
		this.employeeName = employeeName;
		this.employeeCity = employeeCity;
		this.employeeSalary = employeeSalary;
	}
	
	// Getters and Setters
	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public Date getEmployeeDOB() {
		return employeeDOB;
	}

	public void setEmployeeDOB(Date employeeDOB) {
		this.employeeDOB = employeeDOB;
	}

	public Date getEmployeeLastLogin() {
		return employeeLastLogin;
	}

	public void setEmployeeLastLogin(Date employeeLastLogin) {
		this.employeeLastLogin = employeeLastLogin;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public long getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	// toString
	@Override
	public String toString() {
		return "Employee [employeeNo=" + employeeNo + ", employeeDOB=" + employeeDOB + ", employeeLastLogin="
				+ employeeLastLogin + ", employeeName=" + employeeName + ", employeeCity=" + employeeCity
				+ ", employeeSalary=" + employeeSalary + "]";
	}
}
