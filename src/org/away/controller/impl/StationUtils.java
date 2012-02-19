package org.away.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.away.model.Station;

public class StationUtils {

	public static Station findClosest(List<Station> routes, Station rt) {
		int min = 0;

		double mdist = Double.MAX_VALUE;
		for (int i = 0; i < routes.size(); i++) {
			double currmin = routes.get(i).getDistance(rt);
			if (currmin < mdist) {
				min = i;
				mdist = currmin;
			}
		}
		return routes.get(min);
	}

	public static int[] findSimilar(int[] startIds, int[] endIds) {
		List<Integer> similar = new ArrayList<Integer>();
		for (int i = 0; i < endIds.length; i++) {
			for (int j = 0; j < startIds.length; j++) {
				if (endIds[i] == startIds[j]) {
					similar.add(endIds[i]);
				}
			}
		}
		int[] result = new int[similar.size()];
		for (int i = 0; i < similar.size(); i++) {
			result[i] = similar.get(i);
		}
		return result;

	}
}
