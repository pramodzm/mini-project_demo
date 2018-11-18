package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonJdbc;
import com.model.Data;



/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Data> lst=new ArrayList<Data>();
		PersonJdbc pj =new PersonJdbc();
		lst=pj.displayall();
		
		PrintWriter out=response.getWriter();
		out.print("<table><tr><th>Name</th><th>Password</th><th>Email</th><th>Age</th><th>Contact</th></tr>");
		Iterator<Data> it=lst.iterator();
		Data dt=new Data();
		
		if(it.hasNext())
		{
			while(it.hasNext())
			{   
				dt=it.next();

out.println("<tr><td>"+dt.getName()+"</td><td>"+dt.getPass()+"</td><td>"+dt.getEmail()+"</td><td>"+dt.getUname()+"</td><td>"+dt.getName()+"</td></tr>");
			}
		}
		
		else out.println("<h1>No Data Found</h1>");
		
		out.println("</table>");
		
		response.setHeader("Refresh", "10; URL=http://localhost:8182/NoBank/WelcomeAdmin.jsp");
		//response.sendRedirect("WelcomeAdmin.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
