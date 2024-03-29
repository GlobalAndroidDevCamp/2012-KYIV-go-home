package org.away.model;

import java.io.Serializable;
import java.util.List;

public class Itinary implements Serializable {

	private double price;
	private int seconds;
	private List<Transport> transportIds;
	private List<Station> routes;

	public Itinary() {
	}

	public Itinary(double price, int seconds, List<Transport> transportIds,
			List<Station> routes) {
		this.price = price;
		this.seconds = seconds;
		this.transportIds = transportIds;
		this.routes = routes;
	}

	public double getPrice() {
		return price;
	}

	// public void setPrice(double price) {
	// this.price = price;
	// }
	public int getSeconds() {
		return seconds;
	}

	// public void setSeconds(int seconds) {
	// this.seconds = seconds;
	// }
	public List<Transport> getTransportIds() {
		return transportIds;
	}

	// public void setTransportIds(int[] transportIds) {
	// this.transportIds = transportIds;
	// }
	public List<Station> getRoutes() {
		return routes;
	}
}
