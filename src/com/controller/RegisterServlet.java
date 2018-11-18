package com.controller;

import com.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonJdbc;

/**
 * Servlet implementation class RegisterServelet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String uname=request.getParameter("username");
		String pass=request.getParameter("pass");
		String rpass=request.getParameter("repeat-pass");
		
		PrintWriter out=response.getWriter();
		
		if(pass.equals(rpass))
		{
		Data dt=new Data();
		dt.setName(name); dt.setEmail(email); dt.setUname(uname); dt.setPass(pass);
		ArrayList<Data>al=new ArrayList<Data>();
		al.add(dt);
		PersonJdbc pj=new PersonJdbc();
		int i=pj.saveData(al);
		  
		if(i>0)
		{   
	    out.println("<h1> Data Inserted</h1>"); 
	       response.sendRedirect("login.jsp");
		}
		else { out.println("<h1>Data not inserted<h1>");}
		
		}
		
		else {
			out.println("<h1>Password did not match</h1>");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
