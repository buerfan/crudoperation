package com.java.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.model.AccountModel;
import com.java.model.Add;
import com.java.model.CustomerModel;
import com.java.model.EmployeeModel;
import com.java.model.PersonModel;

public class DBData {

	public List<EmployeeModel> getAllEmployeeModels()
	{
		List<EmployeeModel> employeeModel=new ArrayList<>();
		
		Connection con=new Connection();
		Session session=con.getSessionFactory().openSession();
		
		Query query=session.createQuery("from EmployeeModel emp");
		employeeModel=query.list();
		
		return employeeModel;
	}
	
	public List<AccountModel> getAllAccountModels()
	{
		List<AccountModel> accountModel=new ArrayList<>();
		
		Connection con=new Connection();
		Session session=con.getSessionFactory().openSession();
		
		Query query=session.createQuery("from AccountModel acc");
		accountModel=query.list();
		
		return accountModel;
	}
	
	public List<CustomerModel> getAllCustomerModels()
	{
		List<CustomerModel> addCustomerModel=new ArrayList<>();
		
		Connection con=new Connection();
		Session session=con.getSessionFactory().openSession();
		
		Query query=session.createQuery("from CustomerModel cm");
		addCustomerModel=query.list();
		
		return addCustomerModel;
	}
	
	
	public void saveEmployee(EmployeeModel emp) {
		Connection con=new Connection();
		Session session=con.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		session.save(emp);
		t.commit();
		
		System.out.println("Inserted...");
	}
	
	
	public void saveAccount(AccountModel acc) {
		Connection con=new Connection();
		Session session=con.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		session.save(acc);
		t.commit();
		
		System.out.println("Successfully Signed Up...");
	}
	
	public void updateEmployee(EmployeeModel emp) {
		
		Connection con=new Connection();
		Session session=con.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		session.update(emp);
		t.commit();
		System.out.println("Updated...");
	}
	
	public void deleteEmployee(EmployeeModel emp) {
		
		Connection con=new Connection();
		Session session=con.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		session.delete(emp);
		t.commit();
		System.out.println("Deleted...");
	}

	public Add getCustomerById(int id)
	{
		String query1="from Add add where add.customerId="+id;
		
		Connection con=new Connection();
		Session session=con.getSessionFactory().openSession();
		
		Query query2=session.createQuery(query1);
		Add add=(Add) query2.list().get(0);
		
		return add;
	}
	
	public EmployeeModel getEmployeeById(int id)
	{
		String query1="from EmployeeModel emp where emp.employeeId="+id;
		
		Connection con=new Connection();
		Session session=con.getSessionFactory().openSession();
		
		Query query2=session.createQuery(query1);
		EmployeeModel emp=(EmployeeModel) query2.list().get(0);
		
		return emp;
	}

	public void saveCustomer(CustomerModel cm) {
		
		Connection con=new Connection();
		Session session=con.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		session.save(cm);
		t.commit();
		
		System.out.println("Successfully Inserted...");
	}

	public void savePerson(PersonModel pm) {
		Connection con=new Connection();
		Session session=con.getSessionFactory().openSession();
		
		Transaction t=session.beginTransaction();
		session.save(pm);
		t.commit();
		
		System.out.println("Successfully Inserted...");
	}
	
	
}
