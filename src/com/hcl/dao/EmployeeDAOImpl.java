package com.hcl.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hcl.model.Employee;
import com.hibernate.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	// No Argument Constructor
	public EmployeeDAOImpl() {}
	
	// Save Employee
	@Override
	public boolean save(Employee e) {
		Transaction tx = null;
		Session session = HibernateUtil.getSession();
		
		try {
			tx = session.getTransaction();
			tx.begin();
			session.save(e);
			tx.commit();
			return true;
		}
		catch(Exception ex){
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		}
	}

	// Delete Employee
	@Override
	public boolean delete(int empid) {
		Transaction tx = null;
		Session session = HibernateUtil.getSession();
		try {
			tx = session.getTransaction();
			tx.begin();
			Employee e = (Employee)session.get(Employee.class, empid);
			if(e != null) {
				session.delete(e);
			}else {
				throw new Exception("No Employee Found To Be Deleted");
			}
			tx.commit();
			return true;
		}catch(Exception ex) {
			if(tx!= null) {
				tx.rollback();
			}
			ex.printStackTrace();
			return false;
		}
	}

	// Get List Of All Employees
	@Override
	public List<Employee> getAllEmployees() {
		Transaction tx = null;
		List<Employee> emplist = null;
		Session session = HibernateUtil.getSession();
		try {
			tx = session.getTransaction();
			tx.begin();
			Query qry = session.createQuery("from Employee name");
			emplist = qry.list();
		}catch(Exception ex) {
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
		}
		return emplist;
	}

	// Get Employee By Id
	@Override
	public Employee getEmployeeById(int empid) {
		Employee employee = null;
		Transaction tx = null;
		Session session = HibernateUtil.getSession();
		try {
			tx = session.getTransaction();
			tx.begin();
			employee = (Employee) session.get(Employee.class, empid);
		}
		catch(Exception ex) {
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
		}
		return employee;
	}

	// Update Employee By Id
	@Override
	public boolean update(int empid, String newName, String newCity, long newSalary) {
		Employee employee = null;
		Transaction tx = null;
		Session session = HibernateUtil.getSession();
		try {
			tx = session.getTransaction();
			tx.begin();
			employee = (Employee) session.get(Employee.class, empid);
			employee.setEmployeeName(newName);
			employee.setEmployeeCity(newCity);
			employee.setEmployeeSalary(newSalary);
			session.update(employee);
			tx.commit();
			return true;
		}catch(Exception ex) {
			if(tx!=null) {
				tx.rollback();
			}
			ex.printStackTrace();
		}
		return false;
	}
}
