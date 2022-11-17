package org.simplilearn;

import org.simplilearn.entities.Flight;
import org.simplilearn.service.Flightservice;
import org.simplilearn.service.Flightserviceimpl;

public class Test1 {

	public static void main(String[] args) {
		Flightservice service=new Flightserviceimpl();
		Flight flight=new Flight();
		flight.setfNo(4);
		flight.setDate("13/11/2022");
		flight.setSource("mumbai");
		flight.setDestination("delhi");
		flight.setAirlines("Qatar airways");
		flight.setPrice(25000);
		flight.setSeats(124);
		service.addFlight(flight);
		

	}

}
