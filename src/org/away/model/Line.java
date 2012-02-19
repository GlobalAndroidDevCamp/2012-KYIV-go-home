package org.away.model;

public class Line {
	
	private int transportId;
	private int[] stations;

	
	public Line(int trId, int[] stations) {
		this.transportId = trId;
		this.stations = stations;
	}
	
	public int[] getStations() {
		return stations;
	}
	
	public int getTransportId() {
		return transportId;
	}
}
