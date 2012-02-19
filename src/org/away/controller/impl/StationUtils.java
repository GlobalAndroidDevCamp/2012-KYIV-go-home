package org.away.controller.impl;


import java.util.List;

import org.away.model.Station;

public class StationUtils {
	
	public static Station findClosest(List<Station> routes, Station rt) {
		int min = 0;
		
		double mdist = Double.MAX_VALUE;
		for (int i = 0; i < routes.size(); i++) {
			double currmin =routes.get(i).getDistance(rt); 
			if (currmin<mdist) {
				min = i;
				mdist = currmin;
			}
		}
		return routes.get(min);
	}
}
