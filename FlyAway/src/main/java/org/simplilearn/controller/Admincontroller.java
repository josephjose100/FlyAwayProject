package org.simplilearn.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.simplilearn.entities.Admin;
import org.simplilearn.service.Adminservice;
import org.simplilearn.service.Adminserviceimpl;

@WebServlet(value = { "/login","/change","/register" })
public class Admincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Adminservice service=new Adminserviceimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getRequestURI().equals("/FlyAway/register")) {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String adminId=request.getParameter("adminId");
			String password=request.getParameter("password");
			String password1=request.getParameter("password1");
			if(password.equals(password1)) {
				Admin admin=new Admin();
				admin.setAdminId(adminId);
				admin.setPassword(password);
				service.createNewAdmin(admin);
				request.setAttribute("msg", "New admin created");
				RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
				}
			else {
				request.setAttribute("msg", "Please enter the same password in both fields");
				RequestDispatcher rd=request.getRequestDispatcher("/register.jsp");
				rd.forward(request, response);
				
			}
			
		}
		
		
		
		
		if(request.getRequestURI().equals("/FlyAway/login")) {
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String adminId=request.getParameter("adminId");
			String password=request.getParameter("password");
			Admin admin=service.validateAdmin(adminId, password);
			if(admin!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("admin", admin);
				RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
				rd.forward(request, response);
				
				
			}else {
				
				request.setAttribute("msg", "username/password is invalid");
				RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
				
				
			}
			
			
			
		}
		
		if(request.getRequestURI().equals("/FlyAway/change")) {
			
			
			
			boolean isPasswordChanged=false;
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
		    String adminId=request.getParameter("adminId");
			String password=request.getParameter("password");
			String oldPassword=request.getParameter("oldPassword");
			String newPassword=request.getParameter("newPassword");
			String newPassword1=request.getParameter("newPassword1");
		
			if(password.equals(oldPassword)&&newPassword.equals(newPassword1)) {
				
				if(service.changePassword(adminId, newPassword)){
					
					Admin admin=service.validateAdmin(adminId, newPassword);
					if(admin!=null) {
						HttpSession session=request.getSession();
						session.setAttribute("admin", admin);
						request.setAttribute("msg1", "Password changed successfully");
						RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
						rd.forward(request, response);
					}
				}
			}
			else {
				if(password.equals(oldPassword)) {
					request.setAttribute("msg1", "New password on both columns didn't match");
					RequestDispatcher rd=request.getRequestDispatcher("/newPassword.jsp");
					rd.forward(request, response);
				}else {
					request.setAttribute("msg1", "Old password is not correct");
					RequestDispatcher rd=request.getRequestDispatcher("/newPassword.jsp");
					rd.forward(request, response);
			 }
				
	  }
			
	}
 }
}
