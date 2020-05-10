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
		List<Flight> listFlight =  flightdaoimpl.searchFlight();
		List<Flight> finalList = new ArrayList<Flight>();
		for(Flight list:listFlight) {
			Flight flight = new Flight();
			Rout rout = listFlight.getRout();
			List<String> routList = rout.getLocation();
			List<Date> upTime = rout.getUpTime();
			List<Date> downTime = rout.getDownTime();
			List<Integer> dist = rout.getDist();
			for(String rt:routList){
				if(rt.contains(source) && rt.contains(destination)
						&& !source.equals(destination)) {
					int s = rt.indexOf(source);
					int d = rt.indexOf(destination);
					if(s > d) {
						flight.setSource(source);
						flight.setDestination(destination);
						flight.setArrivalTime(upTime.get(s));
						flight.setDestinationTime(upTime.get(d));
						flight.setNoOfStop(d-s);
						int d_dist = dist.get(d);
						int s_dist = dist.get(s);
						int price = Math.abs(d_dist-s_dist)*2 - 500*(Math.abs(d-s));
						if(price <= 0)
								price = 2000;
						flight.setPrice(price);
					}
					if(s < d) {
						flight.setSource(source);
						flight.setDestination(destination);
						flight.setArrivalTime(downTime.get(s));
						flight.setDestinationTime(downTime.get(d));
						flight.setNoOfStop(d-s);
						int d_dist = dist.get(d);
						int s_dist = dist.get(s);
						int price = Math.abs(d_dist-s_dist)*2 - 500*(Math.abs(d-s));
						flight.setPrice(price);
					}
					finalList.add(flight);				
				}
			}
		}
		return finalList;
		
	}

}
