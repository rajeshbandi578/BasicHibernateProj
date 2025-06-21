package com.mph.controller;

/**
 * 
 * 
 *@author Rajesh
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mph.entity.Address;
import com.mph.entity.Department;
import com.mph.entity.Emp;




public class EmpController {
	
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		
		Transaction txn;
		
		public void addEmp() {
			Session session=sessionFactory.openSession();
			txn=session.beginTransaction();
			Scanner sc=new Scanner(System.in);
			
			Department dt=new Department();
			Emp e=new Emp();
			
			List<Address> alist= new ArrayList<Address>();
			System.out.println("Enter number");
			dt.setDno(sc.nextInt());
			sc.nextLine();
			System.out.println("Enter dept name");
			dt.setDname(sc.next());
			System.out.println("Enter your Emp Number ");
			e.setEno(sc.nextInt());
			sc.nextLine();
			System.out.println("Enter name");
			e.setName(sc.nextLine());
			System.out.println("Enter Salary");
			e.setSalary(sc.nextDouble());
			System.out.println("Enter no of addres you have");
			int n=sc.nextInt();
			sc.nextLine();
			for(int i=0;i<n;i++) {
			Address a=new Address();
			System.out.println("Enter city");
			a.setCity(sc.nextLine());
			System.out.println("Enter pin");
			a.setPin(sc.nextInt()); sc.nextLine(); 
			a.setEmp(e);
			alist.add(a);
			session.persist(a);
			}
			e.setAddr(alist);
			e.setDept(dt);
			session.persist(e);
			session.persist(dt);
			txn.commit();
			session.close();
			System.out.println("Emp added to data base chek to confirm");
			
		}
		
		
		public void viewEmp() {
			Session session = sessionFactory.openSession();
			Query<Emp> q =session.createQuery("From Emp",Emp.class);
			List<Emp> elist=q.list();
			for(Emp e : elist) {
				System.out.println(e.toString());
			}
			session.close();
		}
}

