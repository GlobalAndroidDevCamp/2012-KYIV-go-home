package org.away.model;

public class Itinary {
	
	private double price;
	private int seconds;
	private int[] transportIds;

	public Itinary(double price, int seconds, int[] trnasportIds) {
		this.price = price;
		this.seconds = seconds;
		this.transportIds = transportIds;
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
	public int[] getTransportIds() {
		return transportIds;
	}
//	public void setTransportIds(int[] transportIds) {
//		this.transportIds = transportIds;
//	}
}
