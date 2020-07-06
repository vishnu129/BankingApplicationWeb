package com.dxc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pojos.BankUser;

public class AdminDaoImpl implements IadminDao {
	private static Connection conn;
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?autoReconnect=true&useSSL=false", "root","pass");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@Override
	public boolean adminLogin(int id, String password) 
	{
	
		try {
			PreparedStatement pstmt =conn.prepareStatement("select password from admin where id=?");
			pstmt.setInt(1, id);
			ResultSet rset=pstmt.executeQuery();
			rset.next();
			if(rset.getString(1).equals(password))
			{
				return true;
			}
			else
			{
				return false;
			}
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean addUser(int accno, String name, double balance) {
		
		try {
			PreparedStatement pstmt =conn.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, accno);
			pstmt.setString(2, name);
			pstmt.setString(3, "pass");
			pstmt.setDouble(4, balance);
			pstmt.setInt(5, 0);
			pstmt.setDouble(6, 0);
			pstmt.setDouble(7, 0);
			pstmt.setDouble(8, 0);
			pstmt.setDouble(9, 0);
			pstmt.setDouble(10, 0);
			pstmt.execute();
			return true;
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public BankUser userDetails(int accno) {
		try {
			PreparedStatement pstmt =conn.prepareStatement("select name,balance from user where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rset=pstmt.executeQuery();
			BankUser bu = new BankUser();
			rset.next();
			bu.setAccno(accno);
			bu.setName(rset.getString(1));
			bu.setBalance(rset.getDouble(2));
			return bu;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public boolean modifyUser(int accno, String name) {
		try {
			PreparedStatement pstmt =conn.prepareStatement("update user set name=? where accno=?");
			pstmt.setString(1, name);
			pstmt.setInt(2, accno);
			int a=pstmt.executeUpdate();
			System.out.println("modify int "+a);
			if(a==1)
			{
			return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			System.out.println("catch ");
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public double balanceCheck(int accno) 
	{
		try {
			PreparedStatement pstmt =conn.prepareStatement("select balance from user where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rset=pstmt.executeQuery();
			rset.next();
			Double bal=rset.getDouble(1);
			return bal;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return -2;
		}
	}


	@Override
	public boolean closeAccount(int accno) 
	{
		try {
			PreparedStatement pstmt =conn.prepareStatement("delete from user where accno=?");
			pstmt.setInt(1, accno);
			int f=pstmt.executeUpdate();
			if(f==1)
			{
			return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			System.out.println("catch ");
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public List<BankUser> showAll() 
	{
		try {
			
			List<BankUser> list = new ArrayList<>();
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select accno,name,balance from user");
			while(rset.next())
			{
			   list.add(new BankUser(rset.getInt(1),rset.getString(2),rset.getDouble(3)));	
			}
			return list;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public void logOut() {
		
		
		
	}

}
