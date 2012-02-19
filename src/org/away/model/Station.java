package org.away.model;

import java.io.Serializable;
import java.util.Arrays;

import org.away.controller.GeoCodingService.GeoCoordinates;

public class Station implements Serializable {

	private double slat;
	private double slng;
	private String sname;
	private int sdir;
	private int[] slines;
	private int sdot;
	private int[] snears;
	private double plat;
	private double plng;
	private String rname;
	private int[] rlines;
	private int lrase;
	private int[] ldots;
	private int[] lstops;

	public Station() {
		super();
	}

	public Station(double slat, double slng, String sname, int sdir,
			int[] slines, int sdot, int[] snears)// , double plat, double plng,
	// String rname, int[] rlines, int lrase, int[] ldots, int[] lstops) {
	{
		super();
		this.slat = slat;
		this.slng = slng;
		this.sname = sname;
		this.sdir = sdir;
		this.slines = slines;
		this.sdot = sdot;
		this.snears = snears;
		this.plat = plat;
		this.plng = plng;
		this.rname = rname;
		this.rlines = rlines;
		this.lrase = lrase;
		this.ldots = ldots;
		this.lstops = lstops;
	}

	public double getSlat() {
		return slat;
	}

	public double getSlng() {
		return slng;
	}

	public String getSname() {
		return sname;
	}

	public int getSdir() {
		return sdir;
	}

	public int[] getSlines() {
		return slines;
	}

	public int getSdot() {
		return sdot;
	}

	public int[] getSnears() {
		return snears;
	}

	public double getPlat() {
		return plat;
	}

	public double getPlng() {
		return plng;
	}

	public String getRname() {
		return rname;
	}

	public int[] getRlines() {
		return rlines;
	}

	public int getLrase() {
		return lrase;
	}

	public int[] getLdots() {
		return ldots;
	}

	public int[] getLstops() {
		return lstops;
	}

	@Override
	public String toString() {
		return "Route [slat=" + slat + ", slng=" + slng + ", sname=" + sname
				+ ", sdir=" + sdir + ", slines=" + Arrays.toString(slines)
				+ ", sdot=" + sdot + ", snears=" + Arrays.toString(snears)
				+ ", plat=" + plat + ", plng=" + plng + ", rname=" + rname
				+ ", rlines=" + Arrays.toString(rlines) + ", lrase=" + lrase
				+ ", ldots=" + Arrays.toString(ldots) + ", lstops="
				+ Arrays.toString(lstops) + "]";
	}

	public double getDistance(Station other) {
		return Math.sqrt(Math.pow(slng - other.slng, 2)
				+ Math.pow(slat - other.slat, 2));
	}

}
