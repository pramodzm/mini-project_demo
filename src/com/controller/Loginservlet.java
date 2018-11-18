package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PersonJdbc;
import com.model.Data;



/**
 * Servlet implementation class Loginservlet
 */
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email=request.getParameter("username");
		String pass=request.getParameter("pass");
		Data dt=new Data(); Data dt1=new Data();
	    dt.setName(email); dt.setPass(pass);	
		PersonJdbc pj=new PersonJdbc();
		boolean i;
		dt1=pj.admin();  String str=dt1.getName();
		HttpSession session=request.getSession();
		
		if(email.equals(dt1.getName()) && pass.equals(dt1.getPass()))
		{  
			session.setAttribute("str", str);
			   response.sendRedirect("WelcomeAdmin.jsp"); 
			}	
		else {	
		i=pj.validate(dt);
		
		PrintWriter out=response.getWriter();
		
		if(i) 
		{
			session.setAttribute("str", email);
			response.sendRedirect("welcome.jsp");
		    
		}
		  else 
		     { 
			    out.println("<p>Invalid Credentials</p>"); 
			    response.setHeader("Refresh", "2; URL=http://localhost:8182/web_app/login.jsp");
			    //response.sendRedirect("login.jsp"); 
			    }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
