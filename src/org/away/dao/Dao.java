package org.away.dao;

import java.util.List;

import org.away.model.Station;
import org.away.model.Transport;


/**
 * @author VITALIK
 * 
 *
 */
public interface Dao {
	
	List<Station> fetchRoutes();
	List<Transport> fetchTransports();

}
