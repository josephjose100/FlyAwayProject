package org.simplilearn.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.simplilearn.config.HibConfig;
import org.simplilearn.entities.Flight;

public class Flightdaoimpl implements Flightdao {

	private Session getSession() {
		SessionFactory factory = HibConfig.getSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	
	public boolean insert(Flight flight) {
		boolean isInserted=false;
		Session session = getSession();
		Transaction tx = null;
		Flight flight1=session.get(Flight.class,flight.getfNo());
		if(flight1==null) {
		try {
			tx = session.beginTransaction();
			session.save(flight);
			tx.commit();
			isInserted=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return isInserted;
	}

	
	public boolean delete(int fNo) {
      boolean isDeleted=false;
      Session session=getSession();
      Transaction tx=null;
      try {
    	  tx=session.beginTransaction();
    	  Flight flight=session.get(Flight.class, fNo);
    	  session.delete(flight);
    	  tx.commit();
    	  isDeleted=true;
      }catch(Exception e) {
    	  e.printStackTrace();
      }
		return isDeleted;
	}

	public List<Flight> getall() {

		Session session=getSession();
		 Query<Flight> query=session.createQuery("select f from org.simplilearn.entities.Flight f");
		 return query.list();
	}


	
	public void update(int fNo,int seats) {
		Session session=getSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Flight flight=session.get(Flight.class, fNo);
			int seats1=flight.getSeats();
			seats1=seats1-seats;
			flight.setSeats(seats1);
			session.save(flight);
			tx.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}


	
	public List<Object[]> getSourceDestination() {
		Session session=getSession();
		Query query=session.createQuery("select distinct f.source,f.destination from org.simplilearn.entities.Flight f");
		 List<Object[]> srcDestinations= (List<Object[]>)query.list();
	       return srcDestinations;
	        
	}


	
	public List<String> getAirlines() {
		Session session=getSession();
		Query query=session.createQuery("select distinct f.airlines from org.simplilearn.entities.Flight f");
		List<String> airlines= (List<String>)query.list();
	       return airlines;
	}


	
	public Flight get(int fNo) {
		
		Session session=getSession();
		Flight flight=session.get(Flight.class, fNo);
		return flight;
	}


	


}
