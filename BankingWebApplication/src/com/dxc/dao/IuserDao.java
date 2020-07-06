package com.dxc.dao;

import java.util.List;

public interface IuserDao {
	
	public boolean userLogin(int acc,String password);
	public double deposit(int acc,double amount);
	public double withdraw(int accno,double amount);
	public double balanceCheck(int accno);
	public List<Double> statement(int accno);
	public void changePassword(int accno,String Password);
	public void logout();

}
