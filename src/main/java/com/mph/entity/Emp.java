package com.mph.entity;

/**
 * 
 * 
 *@author Rajesh
 *
 */

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.NamedQueries;

@NamedQueries({@NamedQuery(name = "GET_EMP_BYNAME", query = "from Emp e where e.name=:name"),
				@NamedQuery(name = "GET_EMP_BYID", query = "from Emp e where e.eno=:eno")})

@Entity
@Table(name="EMPLOYEE")
public class Emp {
		
		@Id
		private int eno;
		
		private String name;
		
		@OneToOne
		@JoinColumn(name="DEPT_ID")
		private Department dept;
		
		private double salary;
		
		@OneToMany(mappedBy ="emp" ,cascade=CascadeType.ALL)
		private List<Address> addr;
		
		
		
		public int getEno() {
			return eno;
		}
		public void setEno(int eno) {
			this.eno = eno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Department getDept() {
			return dept;
		}
		public void setDept(Department dept) {
			this.dept = dept;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		
		public List<Address> getAddr() {
			return addr;
		}
		public void setAddr(List<Address> addr) {
			this.addr = addr;
		}
		@Override
		public String toString() {
			return "Employee [eid=" + eno + ", name=" + name + ", dept=" + dept + ", salary=" + salary + ", addr="
					+ addr + "]";
		}
		
		
}
