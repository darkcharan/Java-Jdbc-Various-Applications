package com.studentbean;

public class StudentBean {
	private int sno;
	private String sname;
	private String saddr;
	public StudentBean(int sno, String sname, String saddr) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.saddr = saddr;
	}
	public StudentBean() {
		// TODO Auto-generated constructor stub
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	@Override
	public String toString() {
		return "" + sno + "\t" + sname + "\t" + saddr + "";
	}
	
	
	
	

}
