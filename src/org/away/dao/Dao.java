package org.away.dao;

import java.util.List;

import org.away.model.Station;


/**
 * @author VITALIK
 * 
 *
 */
public interface Dao {
	
	List<Station> fetchRoutes();

}
