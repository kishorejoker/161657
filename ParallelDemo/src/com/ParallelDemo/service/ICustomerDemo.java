package com.ParallelDemo.service;

import java.util.List;

import com.ParallelDemo.bean.CustomerDemo;

public interface ICustomerDemo {
	public boolean customerDetails(CustomerDemo cd);
	public double deposit(String mobno,double amt);
	public double withdraw(String mobno,double amt);
	public boolean showBalance(String mobno);
	public String fundTransfer(String rmobno, String smobno, double amt);
	public List<String> printTransactions(String mobno);
	public void displayDetails(String mobno);

}
