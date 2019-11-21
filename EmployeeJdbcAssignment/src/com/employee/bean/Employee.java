package com.employee.bean;

public class Employee {
private int eno;
private String ename;
private String eadd;
public Employee(int eno, String ename, String eadd) {
	super();
	this.eno = eno;
	this.ename = ename;
	this.eadd = eadd;
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
public String getEadd() {
	return eadd;
}
public void setEadd(String eadd) {
	this.eadd = eadd;
}
@Override
public String toString() {
	return "" + eno + "\t" + ename + "" + eadd + "";
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

}
