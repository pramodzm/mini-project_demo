package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PersonJdbc;



/**
 * Servlet implementation class AddMoney
 */
public class AddMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMoney() {
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
		
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("str");
		int paisa=Integer.parseInt(request.getParameter("paisa"));
		PersonJdbc pj=new PersonJdbc();
		
		boolean i=pj.addmoney(paisa,email);
		
		if(i) out.println("Money has beeen added Successfully");
		else out.println("Transaction could not be performed");
		
		response.setHeader("Refresh", "4; URL=http://localhost:8182/NoBank/welcome.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
