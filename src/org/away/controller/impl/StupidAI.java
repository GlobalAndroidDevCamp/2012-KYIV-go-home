package org.away.controller.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.away.configuration.GuiceModule;
import org.away.controller.SuperAI;
import org.away.controller.GeoCodingService.GeoCoordinates;
import org.away.dao.impl.LocalDao;
import org.away.model.Itinary;
import org.away.model.Station;
import org.away.model.Transport;

public class StupidAI implements SuperAI {

	public List<Itinary> bringMeHome(GeoCoordinates start, GeoCoordinates end) {
		List<Itinary> itinaries = new ArrayList<Itinary>();
		List<Station> routes = new LocalDao().fetchRoutes();
		itinaries.add(new Itinary(2.5, 60 * 35, Arrays.asList(new Transport(1,new int[]{2,4}, "name")),Arrays.asList(routes.get(0),routes.get(1))));
		itinaries.add(new Itinary(0.6, 60 * 15, Arrays.asList(new Transport(2,new int[]{1,3}, "name2")),Arrays.asList(routes.get(3),routes.get(4))));
		itinaries.add(new Itinary(2,   60 * 20, Arrays.asList(new Transport(3,new int[]{2  }, "name3")),Arrays.asList(routes.get(2),routes.get(7))));
		itinaries.add(new Itinary(1.25, 60 * 30,Arrays.asList(new Transport(4,new int[]{6,7}, "name4")),Arrays.asList(routes.get(0),routes.get(5))));
		return Collections.unmodifiableList(itinaries);
	}

}
