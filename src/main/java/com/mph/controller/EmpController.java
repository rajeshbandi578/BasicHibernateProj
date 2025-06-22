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


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;





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
		
		public void selectUsingNamedQuery() {
			Session session=sessionFactory.openSession();
			txn=session.beginTransaction();
			Query<Emp> q=session.createNamedQuery("GET_EMP_BYNAME",Emp.class).setParameter("name", "Raj");
			Emp e=q.uniqueResult();
			System.out.println("Emp fetched using Named query : "+e.toString());
			
		}
		
		public void deleteEmployee() {
			Session session=sessionFactory.openSession();
			txn=session.beginTransaction();
			Scanner sc =new Scanner(System.in);
			System.out.println("Enter Emp number to be deleted : ");
			int en = sc.nextInt();
			Emp e=session.get( Emp.class, en);
			if(e!=null) {
				session.remove(e);
			}
			txn.commit();
			session.close();
		}
		
		public void updateEmployee() {
			Session session=sessionFactory.openSession();
			txn=session.beginTransaction();
			Scanner sc =new Scanner(System.in);
			System.out.println("Enter Emp number to be updated : ");
			int en = sc.nextInt();
			sc.nextLine();
			Emp e = session.get(Emp.class, en);
			System.out.println("Enter new name");
			e.setName(sc.nextLine());
			if(e!=null) {
			session.merge(e);
			}
			txn.commit();
			session.close();
			
		}
		
		public void selectUsingCriteriaQuery() {
			Session session=sessionFactory.openSession();
			txn=session.beginTransaction();
			Scanner sc =new Scanner(System.in);
			CriteriaBuilder q=session.getCriteriaBuilder();
			CriteriaQuery<Emp> c =q.createQuery(Emp.class);
			Root r = c.from(Emp.class);
			
			c.select(r).where(q.equal(r.get("name"), "Raj"));
			
			List<Emp> results = session.createQuery(c).getResultList();
			
			for (Emp emp : results) {
			    System.out.println(emp);
			}

			txn.commit();
			session.close();
		}
}

