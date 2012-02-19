package org.away.model;

import java.util.List;

public class Itinary {
	
	private double price;
	private int seconds;
	private List<Integer> transportIds;
	private List<Route> routes;

	public Itinary(double price, int seconds, List<Integer> transportIds, List<Route> routes) {
		this.price = price;
		this.seconds = seconds;
		this.transportIds = transportIds;
		this.routes = routes;
	}
	
	public double getPrice() {
		return price;
	}
//	public void setPrice(double price) {
//		this.price = price;
//	}
	public int getSeconds() {
		return seconds;
	}
//	public void setSeconds(int seconds) {
//		this.seconds = seconds;
//	}
	public List<Integer> getTransportIds() {
		return transportIds;
	}
//	public void setTransportIds(int[] transportIds) {
//		this.transportIds = transportIds;
//	}
	public List<Route> getRoutes() {
		return routes;
	}
}
