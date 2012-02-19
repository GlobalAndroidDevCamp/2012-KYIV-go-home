package org.away.controller;

import java.util.List;

import org.away.controller.GeoCodingService.GeoCoordinates;
import org.away.model.Itinary;

public interface SuperAI {
	List<Itinary> bringMeHome(GeoCoordinates start, GeoCoordinates end);
}
