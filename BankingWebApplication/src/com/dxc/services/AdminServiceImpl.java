package com.dxc.services;

import java.util.List;

import com.dxc.dao.AdminDaoImpl;
import com.dxc.dao.IadminDao;
import com.dxc.pojos.BankUser;

public class AdminServiceImpl implements IAdminService {

	IadminDao admindao = new AdminDaoImpl();
	@Override
	public boolean adminLogin(int id, String password) {
		
		return admindao.adminLogin(id, password);
	}
	
	public boolean addUser(int accno, String name, double balance)
	{

		return admindao.addUser(accno, name, balance);
	}
	
	@Override
	public BankUser userDetails(int accno) 
	{
		
		return admindao.userDetails(accno);
	}
	
	
	@Override
	public boolean modifyUser(int accno, String name) 
	{
		
		return admindao.modifyUser(accno, name);
	}
	@Override
	public double balanceCheck(int accno) 
	{
		return admindao.balanceCheck(accno);
	}
	
	@Override
	public boolean closeAccount(int accno) {
		return admindao.closeAccount(accno);
	}
	
	@Override
	public List<BankUser> showAll() 
	{
		return admindao.showAll();
	}
	
	@Override
	public void logOut() {
		admindao.logOut();
		
	}

}
