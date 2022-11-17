package org.simplilearn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.boot.model.convert.spi.ConverterAutoApplyHandler;
import org.simplilearn.entities.Flight;
import org.simplilearn.service.Flightservice;
import org.simplilearn.service.Flightserviceimpl;

@WebServlet(value = { "/search", "/book","/all","/airlines","/srcDestination","/insert","/delete","/details" })
public class Flightcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Flightservice service = new Flightserviceimpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		if(request.getRequestURI().equals("/FlyAway/all")) {
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			List<Flight> flights=service.getAllFlights();
			request.setAttribute("flights", flights);
			RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
			}
		
         if(request.getRequestURI().equals("/FlyAway/airlines")) {
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			List<String> airlines=service.getFlightAirlines();
			request.setAttribute("airlines", airlines);
			RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
				
		}
		
         if(request.getRequestURI().equals("/FlyAway/srcDestination")) {
 			
 			response.setContentType("text/html");
 			PrintWriter out=response.getWriter();
 			List<Object[]> srcDestinations=service.getFlightSrcDestination();
 			request.setAttribute("srcDestinations", srcDestinations);
 			RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
 			rd.forward(request, response);
 			
 		}
         
         if(request.getRequestURI().equals("/FlyAway/delete")) {
        	 
        	 response.setContentType("text/html");
        	 PrintWriter out=response.getWriter();
             int fNo=Integer.parseInt(request.getParameter("fNo"));
        	 boolean isDeleted=service.removeFlight(fNo);
        	 if(isDeleted) {
        		 List<Flight> flights=service.getAllFlights();
     			request.setAttribute("flights", flights);
     			RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
     			rd.forward(request, response);
        		 
        	 }
        	 
         }
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		if (request.getRequestURI().equals("/FlyAway/search")) {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			String date = request.getParameter("date");
			String personsChecking=request.getParameter("persons");
			int persons = Integer.parseInt(request.getParameter("persons"));
			List<Flight> availableFlights = new ArrayList<>();
			List<Flight> flights = service.getAllFlights();
			for (Flight flight : flights) {
				if (flight.getDate().equals(date) && flight.getSource().equals(source)
						&& flight.getDestination().equals(destination)) {
					if (flight.getSeats() >= persons) {
						availableFlights.add(flight);
					}
				}
			}
			boolean empty=availableFlights.isEmpty();
			if(empty==false) {
			request.setAttribute("persons", persons);
			request.setAttribute("availableFlights", availableFlights);
			RequestDispatcher rd = request.getRequestDispatcher("/booking.jsp");
			rd.forward(request, response);
			}
			else {
				request.setAttribute("msg", "No flight/seat is available as per your given details");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				
			}
		}
		
		if (request.getRequestURI().equals("/FlyAway/book")) {
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			int fNo=Integer.parseInt(request.getParameter("fNo"));
			String name=request.getParameter("name");
			String address=request.getParameter("address");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			int persons=Integer.parseInt(request.getParameter("persons"));
			
			request.setAttribute("fNo", fNo);
			request.setAttribute("name", name);
			request.setAttribute("address", address);
			request.setAttribute("email", email);
			request.setAttribute("phone", phone);
			request.setAttribute("persons", persons);
			service.updateSeat(fNo, persons);
			RequestDispatcher rd=request.getRequestDispatcher("/confirmation.jsp");
			rd.forward(request, response);
		}
		
		if (request.getRequestURI().equals("/FlyAway/insert")) {
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			Flight flight=new Flight();
			flight.setfNo(Integer.parseInt(request.getParameter("fNo")));
			flight.setAirlines(request.getParameter("airlines"));
			flight.setDestination(request.getParameter("destination"));
			flight.setSource(request.getParameter("source"));
			flight.setPrice(Integer.parseInt(request.getParameter("price")));
			flight.setDate(request.getParameter("date"));
			flight.setSeats(Integer.parseInt(request.getParameter("seats")));
			boolean flightAdded=service.addFlight(flight);
			if(flightAdded) {
				
				 request.setAttribute("msg", "Flight details added successfully");
				 RequestDispatcher rd=request.getRequestDispatcher("/insert.jsp");
				 rd.forward(request, response);
			}
			else {
				 request.setAttribute("msg", "Adding flight details failed--Check whether the Flight number is different");
				 RequestDispatcher rd=request.getRequestDispatcher("/insert.jsp");
				 rd.forward(request, response);
				
			}
			
		}
		
		if (request.getRequestURI().equals("/FlyAway/details")) {
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			int fNo=Integer.parseInt(request.getParameter("fNo"));
			String name=request.getParameter("name");
		    String address=request.getParameter("address");
		    String email=request.getParameter("email");
		    String phone=request.getParameter("phone");
		    int persons=Integer.parseInt(request.getParameter("persons"));
			Flight flight=service.getFlight(fNo);
            String source=flight.getSource();
            String destination=flight.getDestination();
            String date=flight.getDate();
            int price=flight.getPrice();
            String airlines=flight.getAirlines();
			request.setAttribute("fNo", fNo);
			request.setAttribute("name", name);
			request.setAttribute("address", address);
			request.setAttribute("email", email);
			request.setAttribute("phone", phone);
			request.setAttribute("persons", persons);
			request.setAttribute("soure", source);
			request.setAttribute("destination", destination);
			request.setAttribute("date",date);
			request.setAttribute("price",price);
			request.setAttribute("airlines",airlines);
			RequestDispatcher rd=request.getRequestDispatcher("/details.jsp");
			 rd.forward(request, response);
			
			
			
		}
	}
}
