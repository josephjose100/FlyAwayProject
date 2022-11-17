package org.simplilearn.service;

import java.util.ArrayList;
import java.util.List;

import org.simplilearn.dao.Flightdao;
import org.simplilearn.dao.Flightdaoimpl;
import org.simplilearn.entities.Flight;

public class Flightserviceimpl implements Flightservice {

	Flightdao dao=new Flightdaoimpl();
	public boolean addFlight(Flight flight) {
		boolean isAdded=false;
		if(dao.insert(flight)) {
			isAdded=true;
		}
		return isAdded;
	}


	public boolean removeFlight(int fNo) {
        boolean isRemoved=false;
		if(dao.delete(fNo)) {
			isRemoved=true;
		}
		return isRemoved;
	}

	
	public List<Flight> getAllFlights() {
		List<Flight> flights=new ArrayList<>();
		flights=dao.getall();
		return flights;
		
	}


	
	public void updateSeat(int fNo, int seats) {
		dao.update(fNo, seats);
		
	}


	
	public List<Object[]> getFlightSrcDestination() {
		List<Object[]> srcDestinations=dao.getSourceDestination();
		return srcDestinations;
	}


	
	public List<String> getFlightAirlines() {
		List<String> airlines=dao.getAirlines();
		return airlines;
	}


	
	public Flight getFlight(int fNo) {
		return dao.get(fNo);
	}

}
