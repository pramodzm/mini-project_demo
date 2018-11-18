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
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		String name=request.getParameter("uname");
         PersonJdbc pj=new PersonJdbc();
         out.println("<h1>Printing before</h1>");
         ArrayList<Data> lst=pj.search(name);
         out.println("<h1>After</h1>");
         
         //out.println("Printing");
         
         Iterator<Data> it=lst.iterator(); 
         Data dt=new Data();
         
         if(it.hasNext())
         {
        	 while(it.hasNext())
        	 {
        		 dt=it.next();
        		 
           out.println("<tr><td>"+dt.getName()+"</td><td>"+dt.getPass()+"</td><td>"+dt.getEmail()+"</td><td>"+dt.getUname()+"</td><td>"+dt.getName()+"</td></tr>");
        	 }
        	 response.setHeader("Refresh", "10; URL=http://localhost:8182/NoBank/WelcomeAdmin.jsp");
         }
         else 
        	 {
        	 out.println("<h1>No Data Found</h1>");
        	 response.setHeader("Refresh", "10; URL=http://localhost:8182/NoBank/WelcomeAdmin.jsp");
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
