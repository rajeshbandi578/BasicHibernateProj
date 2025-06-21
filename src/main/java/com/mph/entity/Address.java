package com.mph.entity;

/**
 * 
 * 
 *@author Rajesh
 *
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {
		
		@Id
		@GeneratedValue
		private int ano;
		private String city;
		private int pin;
		
		@ManyToOne()
		@JoinColumn(name="eno")
		private Emp emp;
		
		
		public int getAno() {
			return ano;
		}
		public void setAno(int ano) {
			this.ano = ano;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public int getPin() {
			return pin;
		}
		public void setPin(int pin) {
			this.pin = pin;
		}
		
		
		public Emp getEmp() {
			return emp;
		}
		public void setEmp(Emp emp) {
			this.emp = emp;
		}
		@Override
		public String toString() {
			return "Address [ano=" + ano + ", city=" + city + ", pin=" + pin +  "]";
		}
		
		
		
		
}
