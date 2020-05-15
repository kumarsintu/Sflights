package com.gautam.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gautam.dao.FlightDAOImpl;
import com.gautam.model.Flight;
import com.gautam.model.Rout;

@Service(value = "flightservice")
@Transactional
public class FlightServiceImpl implements FlightService{
	
	@Autowired 
	private	FlightDAOImpl flightdaoimpl;
	
	@Override
	public List<Flight> searchFlight(String source, String destination, Date date) throws Exception{
		
		
	}

}
