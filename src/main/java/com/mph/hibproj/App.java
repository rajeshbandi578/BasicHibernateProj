package com.mph.hibproj;

import java.util.Scanner;

import com.mph.controller.EmpController;

/**
 * 
 * 
 *@author Rajesh
 *
 */

public class App 
{
    public static void main( String[] args ) {
    
    	EmpController ec= new EmpController();
    	Scanner sc=new Scanner(System.in);
    	String s=null;
    	
    	do
    	{
    		System.out.println("Enter your Choice:");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Criteria Query");
			System.out.println("4. Named Query");
			System.out.println("5. Delete Employee");
			System.out.println("6. Update Employee");
		int n = sc.nextInt();
		if(n<7) {
		switch(n) {
		case 1:
			ec.addEmp();
			break;
		case 2:
			ec.viewEmp();
			break;
		case 3:
			ec.selectUsingCriteriaQuery();
			break;
		case 4:
			ec.selectUsingNamedQuery();
			break;
		case 5:
			ec.deleteEmployee();
			break;
		case 6:
			ec.updateEmployee();
			break;
		}}else System.out.println("wrong input");
		
		System.out.println("Do you want to continue??? Y or y");
		s=sc.next();
    	}while(s.equals("Y") || s.equals("y"));
    }
}