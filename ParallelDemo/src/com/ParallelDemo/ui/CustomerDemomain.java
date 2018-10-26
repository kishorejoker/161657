package com.ParallelDemo.ui;

import java.util.Scanner;

import com.ParallelDemo.bean.CustomerDemo;
import com.ParallelDemo.service.ICustomerDemo;
import com.ParallelDemo.service.ImpCustomerDemo;

public class CustomerDemomain {
	
	static CustomerDemomain cdm = new CustomerDemomain();
	static CustomerDemo cd = new CustomerDemo();
	static Scanner sc = new Scanner(System.in);
	static ImpCustomerDemo icd = new ImpCustomerDemo();
	long accnum = 1000L;

	public static void main(String[] args) {
		
		
		while (true) {
			System.out.println("\nSelect an option:");

			System.out.println("\n1.Create Account, \n2.Deposit, \n3.WithDraw, \n4.Show Balance, \n5.Display Details, \n6.FundTransfer, \n7.PrintTransactions \n8.Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				cdm.createAccount();
				break;
			case 2:
				cdm.deposit();
				break;
			case 3:
				cdm.withdraw();
				break;
			case 4:
				cdm.showBalance();
				break;
			case 5:
				cdm.viewDetails();
				break;
			case 6:
				cdm.fundTransfer();
				break;
			case 7:
				cdm.printTransactions();
				break;
			case 8:
				System.out.println("Are you sure you want to exit? (yes/no)");
				sc.next();
				System.out.println("!----------Thank You Come Again-------------!");
				System.exit(0);
				break;
			default:
					System.out.println("Invalid Operation! Please try again.");
					break;

			}
		}
	}
	
	public void createAccount() {
		cd.setAccountno(accnum);
		System.out.println("\n !Enter the Following Credentials to Create an Account! ");
		System.out.println("----------------------------------------------------------");
		do {
		System.out.println("Enter your Name: ");
			cd.setName(sc.next());
		}while(!icd.isValidName(cd.getName()));
		do {
		System.out.println("Enter your MobileNo: ");
			cd.setMobno(sc.next());
		}while(!icd.isValidMobno(cd.getMobno()));
		do {
		System.out.println("Enter your Address with pincode: ");
			cd.setAddress(sc.next());
		}while(!icd.isValidAddress(cd.getAddress()));
		icd.customerDetails(cd);
		accnum++;
		System.out.println("\nDetails:");
		System.out.println("AccountNumber: "+accnum);
		System.out.println(cd);
		System.out.println(" !--------Account Created---------! ");
			
	}
	
	public void deposit() {
		System.out.println("\nEnter the MobileNo linked to Account: ");
		String mobno = sc.next();
		System.out.println("\nEnter the Amount to Deposit: ");
		double amtd = sc.nextDouble();
		cd.setBalance(icd.deposit(mobno,amtd));
		System.out.println("\n!Your Current Balance is: " + cd.getBalance() + "!");
	}
	
	public void withdraw() {
		System.out.println("Enter the MobileNo linked to your Account: ");
		String mobno = sc.next();
		System.out.println("Enter the Amount to WithDraw: ");
		double amtw = sc.nextDouble();
		cd.setBalance(icd.withdraw(mobno,amtw));
		System.out.println("\n!Your Current Balance is: " + cd.getBalance() + "!");
	}
	
	public void showBalance() {
		System.out.println("Enter Your MobileNo linked to your Account: ");
		String mobno = sc.next();
		icd.showBalance(mobno);
		System.out.println("AccountNumber: "+accnum);
		System.out.println("MobileNo: XXXXXX"+cd.getMobno().substring(6));
		System.out.println("Balance: "+cd.getBalance());
	}
	
	public void viewDetails() {
		System.out.println("\nEnter Your MobileNo linked to your Account: ");
		icd.displayDetails(sc.next());
		System.out.println(cd);
		
	}
	
	public void printTransactions() {
		System.out.println("Enter the MobileNo linked to your Account: ");
		String mobno = sc.next();
		System.out.println("!-----Transactions------!");
		System.out.println(icd.printTransactions(mobno));
	}
	
	public void fundTransfer() {
		System.out.println("Enter Recipient's MobileNo: ");
		String rmobno = sc.next();
		System.out.println("Enter Your MobileNo: ");
		String smobno = sc.next();
		System.out.println("Enter the Amount to be transfer: ");
		double amt = sc.nextDouble();
		if(amt>0) {
			System.out.println(icd.fundTransfer(rmobno,smobno,amt));
		}
	}

}