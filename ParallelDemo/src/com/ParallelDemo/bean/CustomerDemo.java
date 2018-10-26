package com.ParallelDemo.bean;

public class CustomerDemo {
	private long accountno;
	private String name;
	private String mobno;
	private String address;
	private double balance;
	double amt;

	public long getAccountno() {
		return accountno;
	}

	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void setBalance(double amt){
		this.balance=amt;
	}
	
	public String toString(){
		return "FirstName: "+name+"\nAddress: "+address+"\nMobileNo: "+mobno+"\nBalance: "+balance+"\n";
	}

}
