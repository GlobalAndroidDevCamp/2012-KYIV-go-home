package org.away.model;

public enum TransportType {
	TROLLEY(125), BUS(200), TRAM(125);
	
	/** 
	 * ticket price. 1 uah == 100.
	 */
	private int price;

	TransportType(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}	
}
