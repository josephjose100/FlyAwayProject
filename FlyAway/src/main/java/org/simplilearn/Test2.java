package org.simplilearn;

import java.util.List;
import java.util.stream.Collectors;

import org.simplilearn.dao.Flightdao;
import org.simplilearn.dao.Flightdaoimpl;

public class Test2 {

	public static void main(String[] args) {
	Flightdao dao=new Flightdaoimpl();

	List<Object[]>srcDestinations=dao.getSourceDestination();
	for(Object[] srcDestination:srcDestinations) {
		String source = (String)srcDestination[0];
        String destination = (String)srcDestination[1];
        System.out.println(source+"\t"+destination);
        
	}
	
	   List<String>airlines=dao.getAirlines();
	   System.out.println(airlines);
	   
	   
	   
	   
	   
   }
   
	
}

