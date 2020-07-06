package com.dxc.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IuserDao{
	
	private static Connection conn;
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?autoReconnect=true&useSSL=false", "root","pass");
			//System.out.println("connection established");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	@Override
	public boolean userLogin(int acc, String password) {
		
		try {
			PreparedStatement pstmt =conn.prepareStatement("select password from user where accno=?");
			pstmt.setInt(1, acc);
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
	public double deposit(int acc, double amount) 
	{
		
		try {
			double nmt=amount;
			PreparedStatement pstmt =conn.prepareStatement("select balance from user where accno=?");
			pstmt.setInt(1, acc);
			ResultSet rset = pstmt.executeQuery();
			rset.next();
			double amt=rset.getDouble(1);
			amt += amount;
			
			
			PreparedStatement pstmt1 =conn.prepareStatement("update user set balance=? where accno=?");
			pstmt1.setDouble(1, amt);
			pstmt1.setInt(2, acc);
			pstmt1.execute();
			
			PreparedStatement stmt =conn.prepareStatement("select transcount from user where accno=?");
			stmt.setInt(1, acc);
			ResultSet rset1=stmt.executeQuery();
			rset1.next();
			int count=rset1.getInt(1);
			//System.out.println("count is"+count+"and acc no is "+acc);
			
			switch(count)
			{
			case 0:
				PreparedStatement pstmt2 =conn.prepareStatement("update user set transcount=? , trans1=? where accno=?");
				pstmt2.setInt(1, 1);
				pstmt2.setDouble(2, nmt);
				pstmt2.setInt(3, acc);
				pstmt2.execute();
				
				break;
			case 1:
				PreparedStatement pstmt3 =conn.prepareStatement("update user set transcount=? , trans2=? where accno=?");
				pstmt3.setInt(1, 2);
				pstmt3.setDouble(2, nmt);
				pstmt3.setInt(3, acc);
				pstmt3.execute();
				break;
			case 2:
				PreparedStatement pstmt4 =conn.prepareStatement("update user set transcount=? , trans3=? where accno=?");
				pstmt4.setInt(1, 3);
				pstmt4.setDouble(2, nmt);
				pstmt4.setInt(3, acc);
				pstmt4.execute();
				break;
			case 3:
				PreparedStatement pstmt5 =conn.prepareStatement("update user set transcount=? , trans4=? where accno=?");
				pstmt5.setInt(1, 4);
				pstmt5.setDouble(2, nmt);
				pstmt5.setInt(3, acc);
				pstmt5.execute();
				break;
			case 4:
				PreparedStatement pstmt6 =conn.prepareStatement("update user set transcount=? , trans5=? where accno=?");
				pstmt6.setInt(1, 0);
				pstmt6.setDouble(2, nmt);
				pstmt6.setInt(3, acc);
				pstmt6.execute();
				break;
			}
			
		
		return amt;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return -1;
		}
		
		
	}



	@Override
	public double withdraw(int accno, double amount)
	{
		try {
			double nmt=0-amount;
			PreparedStatement pstmt =conn.prepareStatement("select balance from user where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rset = pstmt.executeQuery();
			rset.next();
			double accbal=rset.getDouble(1);
			accbal -= amount;
			
			
			PreparedStatement pstmt1 =conn.prepareStatement("update user set balance=? where accno=?");
			pstmt1.setDouble(1, accbal);
			pstmt1.setInt(2, accno);
			pstmt1.execute();
			
			PreparedStatement stmt =conn.prepareStatement("select transcount from user where accno=?");
			stmt.setInt(1, accno);
			ResultSet rset1=stmt.executeQuery();
			rset1.next();
			int count=rset1.getInt(1);
			//System.out.println("count is"+count);
			
			switch(count)
			{
			case 0:
				PreparedStatement pstmt2 =conn.prepareStatement("update user set transcount=? , trans1=? where accno=?");
				pstmt2.setInt(1, 1);
				pstmt2.setDouble(2, nmt);
				pstmt2.setInt(3, accno);
				pstmt2.execute();
				
				break;
			case 1:
				PreparedStatement pstmt3 =conn.prepareStatement("update user set transcount=? , trans2=? where accno=?");
				pstmt3.setInt(1, 2);
				pstmt3.setDouble(2, nmt);
				pstmt3.setInt(3, accno);
				pstmt3.execute();
				break;
			case 2:
				PreparedStatement pstmt4 =conn.prepareStatement("update user set transcount=? , trans3=? where accno=?");
				pstmt4.setInt(1, 3);
				pstmt4.setDouble(2, nmt);
				pstmt4.setInt(3, accno);
				pstmt4.execute();
				break;
			case 3:
				PreparedStatement pstmt5 =conn.prepareStatement("update user set transcount=? , trans4=? where accno=?");
				pstmt5.setInt(1, 4);
				pstmt5.setDouble(2, nmt);
				pstmt5.setInt(3, accno);
				pstmt5.execute();
				break;
			case 4:
				PreparedStatement pstmt6 =conn.prepareStatement("update user set transcount=? , trans5=? where accno=?");
				pstmt6.setInt(1, 0);
				pstmt6.setDouble(2, nmt);
				pstmt6.setInt(3, accno);
				pstmt6.execute();
				break;
			}
			
			return accbal;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
			
		}
				
	}


	@Override
	public double balanceCheck(int accno) {
		try {
			PreparedStatement pstmt =conn.prepareStatement("select balance from user where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rset=pstmt.executeQuery();
			rset.next();
			Double bal=rset.getDouble(1);
			return bal;
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("exception called");
			return -1;
		}
	}


	@Override
	public List<Double> statement(int accno) {

		try {
			List<Double> list = new ArrayList<>();
			PreparedStatement pstmt =conn.prepareStatement("select trans1,trans2,trans3,trans4,trans5,transcount from user where accno=?");
			pstmt.setInt(1, accno);
			ResultSet rset=pstmt.executeQuery();
			rset.next();
			list.add(rset.getDouble(1));
			list.add(rset.getDouble(2));
			list.add(rset.getDouble(3));
			list.add(rset.getDouble(4));
			list.add(rset.getDouble(5));
			
			//list now have the last 5 transaction but in scrambled order
			
			//the below code is to print statement in correct transaction order of actions
			
			int temp=rset.getInt(6);
			List <Double> rlist= new ArrayList<>();
			int n=0;
			for(int i=temp-1;i>=0;i--)
			{
				double d=list.get(i);
				rlist.add(n, d);
				n++;
			}
			int m=temp;
			for(int j=4;j>temp-1;j--)
			{
				double b=list.get(j);
				rlist.add(m, b);
				m++;
			}
			
			
			return rlist;
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public void changePassword(int accno, String Password) 
	{
		try {
			PreparedStatement pstmt =conn.prepareStatement("update user set password=? where accno=?");
			pstmt.setString(1, Password);
			pstmt.setInt(2, accno);
			pstmt.execute();
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}


	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
