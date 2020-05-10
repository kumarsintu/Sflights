package com.gautam.dao;

import java.util.List;

import com.gautam.model.Flight;

public interface FlightDAO {
	public List<Flight> searchFlight() throws Exception;
}
