package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.BankUser;

public interface IadminDao {
	
	public boolean adminLogin(int id, String password);
	public boolean addUser(int accno,String name,double balance);
	public BankUser userDetails(int accno);
	public boolean modifyUser(int accno,String name);
	public double balanceCheck(int accno);
	public boolean closeAccount(int accno);
	public List<BankUser> showAll();
	public void logOut();

}
