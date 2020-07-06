package com.dxc.pojos;

public class BankUser {
	
	private int accno;
	private String name;
	private double balance;
	
	public BankUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankUser(int accno, String name, double balance) 
	{
		super();
		this.accno = accno;
		this.name = name;
		this.balance = balance;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankUser [accno=" + accno + ", name=" + name + ", balance=" + balance + "]";
	}
	

}
