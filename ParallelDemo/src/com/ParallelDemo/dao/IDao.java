package com.ParallelDemo.dao;

import java.util.List;

import com.ParallelDemo.bean.CustomerDemo;

public interface IDao {
	public boolean customerDetails(CustomerDemo cd);
	public boolean deposit(String mobno,String log);
	public boolean withdraw(String mobno,String log);
	public boolean showBalance(String mobno);
	public boolean fundTransfer(String rmobno,String smobno,double amt);
	public void createTransactions(String mobno);
	public CustomerDemo findOne(String mobno);
	public CustomerDemo displayDetails(String mobno);
	public List<String> printTransactions(String mobno);
}
