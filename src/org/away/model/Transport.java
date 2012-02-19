package org.away.model;

public class Transport {
	private int id;
	/**
	 * tram 1 has 1 line. tram 2 has 2 lines: from pasichna to chuprynky and back 
	 */
	private int[] lineId;
	private String name;
	private TransportType type;
	
	public Transport(int id, int[] lineId, String name) {
		this.id = id;
		this.name = name;
		this.lineId = lineId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public TransportType getType() {
		if (name.startsWith("Трм")) {
			return TransportType.TRAM;
		} else if (name.startsWith("Трл")) {
			return TransportType.TROLLEY;
		} else {
			return TransportType.BUS;
		}
	}
	
	
}
