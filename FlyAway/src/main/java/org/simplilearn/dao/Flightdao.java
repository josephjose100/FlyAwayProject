package org.simplilearn.dao;

import java.util.List;

import org.simplilearn.entities.Flight;

public interface Flightdao {
	
	boolean insert(Flight flight);
    boolean delete(int fNo);
    List<Flight> getall();
    void update(int fNo,int seats);
    List<Object[]> getSourceDestination();
    List<String> getAirlines();
    Flight get(int fNo);


}
