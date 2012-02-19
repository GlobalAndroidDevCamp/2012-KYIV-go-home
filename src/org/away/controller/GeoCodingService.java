package org.away.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.inject.Inject;

public class GeoCodingService {

	private Geocoder geocodder;

	@Inject
	public GeoCodingService(Context context) {
		this.geocodder = new Geocoder(context, Locale.US);
	}

	public Address getAddressbyLocation(double lattitude, double longitude)
			throws IOException {
		List<Address> addresses = geocodder.getFromLocation(lattitude,
				longitude, 1);
		return (addresses.isEmpty()) ? null : addresses.get(0);
	}

	public GeoCoordinates getGeoCoordinatesByAddress(String locationName)
			throws IOException {
		List<Address> addresses = geocodder
				.getFromLocationName(locationName, 1);
		return (addresses.isEmpty()) ? null : new GeoCoordinates(addresses.get(
				0).getLongitude(), addresses.get(0).getLatitude());
	}

	public static class GeoCoordinates implements Serializable {
		
		private static final long serialVersionUID = -188122163934343700L;
		
		private double longtitude;
		private double lattitude;

		public GeoCoordinates() {
		}

		public GeoCoordinates(double longtitude, double lattitude) {
			super();
			this.longtitude = longtitude;
			this.lattitude = lattitude;
		}

		public double getLongtitude() {
			return longtitude;
		}

		public double getLattitude() {
			return lattitude;
		}

		public double getDistance(GeoCoordinates other) {
			return Math.sqrt(Math.pow(longtitude-other.longtitude,2) + Math.pow(lattitude-other.lattitude,2));
		}

		@Override
		public String toString() {
			return "GeoCoordinates [longtitude=" + longtitude + ", lattitude="
					+ lattitude + "]";
		}

	}

}
