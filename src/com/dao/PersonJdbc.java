package com.dao;

import com.dao.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.model.Data;


public class PersonJdbc {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int i;
	public Connection myConnection(){
		//1.load driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Newuser123");
			System.out.println("Connection to db..");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("catch connection..");
		} catch (SQLException e) {
			System.out.println("catch connection..2");
			e.printStackTrace();
		}
		return con;
	}
	public int saveData(ArrayList<Data> al){
		try {
			Iterator<Data> it = al.iterator();
			while(it.hasNext()) 
			{
			 Data su =it.next();
			con=myConnection();
			ps=con.prepareStatement("insert into member values(?,?,?,?)");
			ps.setString(1,su.getName());
			ps.setString(2,su.getEmail());
			ps.setString(3,su.getUname());
			ps.setString(4, su.getPass());
			i = ps.executeUpdate();
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("test11");
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println("global.."+e);
		}
		return i;
	}
	public boolean validate(Data dt)
	{
		con=myConnection();
	  Statement st=null;
	  try {
		st=con.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  ResultSet rs=null;
	try {
		rs = st.executeQuery("Select email,password from Member");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  try {
		while(rs.next())
		  {
			  if(dt.getName().equals(rs.getString(1)) && dt.getPass().equals(rs.getString(2))) return true;
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
	}
	public Data admin()
	{
		con=myConnection();
		Data dt=new Data();
		Statement st=null;
		try {
			st=con.createStatement();
			ResultSet rs=null;
			rs=st.executeQuery("Select *from admin");
			while(rs.next())
			{
				dt.setName(rs.getString(1));
				dt.setPass(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dt;
	}
	public ArrayList<Data> displayall()
	{
		ArrayList<Data>lst=new ArrayList<Data>();
		con=myConnection();
		Statement st=null;
		try {
			st=con.createStatement();
			ResultSet rs=null;
			rs=st.executeQuery("Select * from member");
			while(rs.next())
			{
				Data dt=new Data();
dt.setName(rs.getString(1)); 
dt.setUname(rs.getString(2)); 
dt.setEmail(rs.getString(3)); 
dt.setPass(rs.getString(4));	

			   lst.add(dt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lst;
	}
	
	
	public ArrayList<Data> search(String str)
	{
		ArrayList<Data> lst=new ArrayList<Data>();
		con=myConnection();
	      	
	     System.out.println("ENTERED search function");
		ResultSet rs=null;
			try {
				ps=con.prepareStatement("Select* from member where name=?");
				ps.setString(1, str);
				
				rs=ps.executeQuery();
				
				while(rs.next())
				{   
					
						Data dt=new Data();
						dt.setName(rs.getString(1));
					
				    dt.setPass(rs.getString(2));
				    dt.setEmail(rs.getString(3));
				   // dt.setAge(rs.getInt(4));
				   // dt.setContact(rs.getLong(5));  
				    lst.add(dt);  
					
					
     }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return lst;
	}
	
	public boolean addmoney(int money,String email)
	{
		int i=-1;
		con=myConnection();
		
		try {
			ps=con.prepareStatement("update member set amount=amount+? where email=?");
			ps.setInt(1, money);
			ps.setString(2, email);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(i>0)
			return true;
		
		return false;
	}
	
	
	
	public int checkbalance(String email)
	{   
		int i=-1;
		 ResultSet rs=null;
		con=myConnection();
	    try {
			ps=con.prepareStatement("Select amount from member where email=? ");
			ps.setString(1, email);
			rs=ps.executeQuery();
			rs.next();
			i=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return i;
	}
	
	public boolean deduct_balance(int plan,String email)
	{   
		int i=-1;
		con=myConnection();
		try {
			ps=con.prepareStatement("update member set amount=amount-? where email=?");
			ps.setInt(1, plan);
			ps.setString(2, email);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(i>0)
		return true;
		
		return false;
		
	}
	
	
	

	
	}
	
	

