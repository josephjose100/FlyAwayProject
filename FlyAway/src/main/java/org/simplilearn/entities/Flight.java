package org.simplilearn.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	private int fNo;
	private String date;
	private String source;
	private String destination;
	private String airlines;
	private int price;
	private int seats;

	public Flight() {

	}

	public Flight(int fNo, String date, String source, String destination, String airlines, int price, int seats) {
		super();
		this.fNo = fNo;
		this.date = date;
		this.source = source;
		this.destination = destination;
		this.airlines = airlines;
		this.price = price;
		this.seats = seats;
	}

	public int getfNo() {
		return fNo;
	}

	public void setfNo(int fNo) {
		this.fNo = fNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAirlines() {
		return airlines;
	}

	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

}
