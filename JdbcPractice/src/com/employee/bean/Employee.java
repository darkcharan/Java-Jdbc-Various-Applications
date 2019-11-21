package com.employee.bean;

public class Employee {
 private int eno;
 private String ename;
 private String eaddr;
public Employee(int eno, String ename, String eaddr) {
	super();
	this.eno = eno;
	this.ename = ename;
	this.eaddr = eaddr;
}

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}


public int getEno() {
	return eno;
}
public void setEno(int eno) {
	this.eno = eno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEaddr() {
	return eaddr;
}
public void setEaddr(String eaddr) {
	this.eaddr = eaddr;
}
@Override
public String toString() {
	return "" + eno + "\t" + ename + "\t" + eaddr + "";
}
 
 

}
