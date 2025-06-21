package com.mph.entity;

/**
 * 
 * 
 *@author Rajesh
 *
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {
		
		@Id
		private int dno;
		@Column(name="DEPT_NAME")
		private String dname;
		
		
		public int getDno() {
			return dno;
		}
		public void setDno(int dno) {
			this.dno = dno;
		}
		public String getDname() {
			return dname;
		}
		public void setDname(String dname) {
			this.dname = dname;
		}
		@Override
		public String toString() {
			return "Department [dno=" + dno + ", dname=" + dname + "]";
		}
		
		
}
