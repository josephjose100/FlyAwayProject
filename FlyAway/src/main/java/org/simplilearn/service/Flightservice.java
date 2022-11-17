package org.simplilearn.service;

import java.util.List;

import org.simplilearn.entities.Flight;

public interface Flightservice {

	boolean addFlight(Flight flight);
	boolean removeFlight(int fNo);
	List<Flight> getAllFlights();
	void updateSeat(int fNo,int seats);
	List<Object[]> getFlightSrcDestination();
	List<String> getFlightAirlines();
	Flight getFlight(int fNo);
}
