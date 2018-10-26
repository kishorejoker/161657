package com.ParallelDemo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ParallelDemo.bean.CustomerDemo;
import com.ParallelDemo.exception.InvalidInputException;

public class ImpDao implements IDao {
	CustomerDemo cd = new CustomerDemo();
	
	Map<String,CustomerDemo> account = new HashMap<String,CustomerDemo>();
	Map<String, List<String>> transactions = new HashMap<String, List<String>>();
	List<String> list = new ArrayList<String>();

	public boolean customerDetails(CustomerDemo cd) {
		
		return account.put(cd.getMobno(),cd) != null;	
		}
	
	public CustomerDemo findOne(String mobno) {
		if(account.containsKey(mobno)) {
			return account.get(mobno);
		}
		else 
			return null;
	}
	
	public void createTransactions(String mobno) {
		list.add( new Date()+ "\t Account Created Successfully!\n");
		transactions.put(mobno,list);
	}

	@Override
	public boolean deposit(String mobno,String log) {
		// TODO Auto-generated method stub
		if(transactions.containsKey(mobno)&& account.containsKey(mobno)) {
			account.put(mobno,cd);
			list.add(log);
			transactions.put(mobno, list);
			return true;
		}
		else {
			throw new InvalidInputException(" : Deposit is Not Done! ");
		}
	}

	@Override
	public boolean withdraw(String mobno,String log) {
		// TODO Auto-generated method stub
		if(transactions.containsKey(mobno)&& account.containsKey(mobno)) {
			account.put(mobno,cd);
			list.add(log);
			transactions.put(mobno,list);
			return true;
		}
		else {
			throw new InvalidInputException(" : Deposit is Not Done! ");
		}
			}
	
	@Override
	public boolean showBalance(String mobno) {
		// TODO Auto-generated method stub
		return account.containsKey(mobno);
	}

	@Override
	public CustomerDemo displayDetails(String mobno) {
		// TODO Auto-generated method stub
		
		/*Set<Integer> keys = account.keySet();
		Iterator<Integer> it = keys.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println("\n"+account.get(key));*/
		
		//Print Every details inside the account
		/*for(Map.Entry m:account.entrySet()) {
			System.out.println("Details: \nMobileno: "+m.getKey()+"\n"+m.getValue());
		}*/
		
		if(account.containsKey(mobno)) {
		 return(account.get(mobno));
		}
		else {
			throw new InvalidInputException(" : Something Went Wrong! Try Again Later!!!");
		}
	}
	
	@Override
	public boolean fundTransfer(String rmobno, String smobno, double amt) {
		// TODO Auto-generated method stub
		return (account.containsKey(smobno)&&account.containsKey(rmobno));
	}
	
	@Override
	public List<String> printTransactions(String mobno){
		if(transactions.containsKey(mobno)) {
			return transactions.get(mobno);
		}
		else {
			throw new InvalidInputException(" : Invalid MobileNo.");
		}
	}
}



