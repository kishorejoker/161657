package com.ParallelDemo.service;

import java.util.List;

import com.ParallelDemo.bean.CustomerDemo;
import com.ParallelDemo.dao.IDao;
import com.ParallelDemo.dao.ImpDao;
import com.ParallelDemo.exception.InvalidInputException;




public  class ImpCustomerDemo implements ICustomerDemo {
	IDao dao=new ImpDao();
	CustomerDemo cd = new CustomerDemo();
	double bal; 

	@Override
	public boolean customerDetails(CustomerDemo cd) {
		// TODO Auto-generated method stub
		if(isValidName(cd.getName())&&isValidMobno(cd.getMobno())) {
			if(dao.findOne(cd.getMobno())!=null) {
				throw new InvalidInputException(" :Account with this number is Already Exists!");
			}
			else {
				dao.createTransactions(cd.getMobno());
		return dao.customerDetails(cd);
		}
		}
		else {
			throw new InvalidInputException(" : INVALID INPUTS.");
		}
	}

	@Override
	public double deposit(String mobno,double amt) {
		// TODO Auto-generated method stub
		if(isValidMobno(mobno)&&isValidamt(amt)){
			bal =cd.getBalance();
			bal=bal+amt;
			cd.setBalance(bal);
			String log = "\n"+amt+" is Credited to your Account Linked MobileNo is xxxxxx"+mobno.substring(6)+ " \nYour Current Balance is "+bal+"\n";
			dao.deposit(mobno,log);
			return bal;
		}
		else {
			throw new InvalidInputException(" : MobileNo or Amount is INVALID!!!");
		}
	}

	

	@Override
	public double withdraw(String mobno, double amt) {
		// TODO Auto-generated method stub
		if(isValidMobno(mobno)&&isValidamt(amt)) {
		bal =cd.getBalance();
		if(amt>0){
			bal=bal-amt;
		}
		cd.setBalance(bal);
		String log = "\n"+amt+" is Debited from your Account Linked MobileNo is xxxxxx"+mobno.substring(6)+ " \nYour Current Balance is "+bal+"\n";
		dao.withdraw(mobno,log);
		return bal;
	}
		else {
			throw new InvalidInputException(" : Withdraw is Not Done!");
		}
	}
	
	@Override
	public boolean showBalance(String mobno) {
		// TODO Auto-generated method stub
		if(isValidMobno(mobno)) {
			return dao.showBalance(mobno);
		}
		else {
			throw new InvalidInputException(" : Invalid MobileNo.");
		}
	}

	@Override
	public void displayDetails(String mobno) {
		// TODO Auto-generated method stub
		if(isValidMobno(mobno)){
		dao.displayDetails(mobno);	
	}
}
	
	@Override
	public String fundTransfer(String rmobno, String smobno, double amt) {
		// TODO Auto-generated method stub
		if(isValidMobno(rmobno)&&isValidMobno(smobno)&&isValidamt(amt)) {
			if(dao.fundTransfer(rmobno,smobno,amt)) {
				String log = subract(smobno,amt);
				dao.withdraw(smobno, log);
				String log1 = addition(rmobno,amt);
				dao.deposit(rmobno, log1);
			}
			return "!Amount Transfered successfully!";
		}
		else {
			throw new InvalidInputException(" :Invalid Details.");
		}
	}
	
	@Override
	public List<String> printTransactions(String mobno){
		if(isValidMobno(mobno)) {
			return dao.printTransactions(mobno);
		}
		else {
			throw new InvalidInputException(" : Invalid MobileNo.");
		}
	}
	
	public boolean isValidName(String name) {
		if (((name != null) && name.matches("[A-Za-z]+"))) {
			return true;
		} else {
			throw new InvalidInputException(" : Name cannot be NULL (or) INVALID Name.");
		}
	}
	
	public boolean isValidMobno(String mobno) {
		if((mobno != null)&& mobno.matches("[4-9][0-9]{9}")) {
			return true;
		}
		else {
			throw new InvalidInputException(" : Mobileno cannot be Null (or) INVALID Mobileno." );
		}
	}

	public boolean isValidAddress(String address) {
		if((address!=null)&&address.matches("(?=.*[0-9])[A-Za-z0-9]+")) {
			return true;
		}
		else {
			throw new InvalidInputException(" : Address cannot be Null (or) INVALID Address.");
		}
	}
	
	public boolean isValidamt(double amt) {
		// TODO Auto-generated method stub
		return amt>0;
	}
	
	public String subract(String mobno,double amt) {
		double bal = cd.getBalance();
		if(isValidMobno(mobno)) {
			bal = bal-amt;
		}
		String log = "\n"+amt+" is debited from your account.";
		return log;
	}
	
	public String addition(String mobno,double amt) {
		double bal = cd.getBalance();
		if(isValidMobno(mobno)) {
			bal = bal+amt;
		}
		String log = "\n"+amt+" is credited from your account.";
		return log;
	}
	
}
	

