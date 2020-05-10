package com.gautam.service;

import java.util.Date;
import java.util.List;

import com.gautam.model.Flight;

public interface FlightService {
	public List<Flight> searchFlight(String source, String destination, Date date)
				throws Exception;
}
