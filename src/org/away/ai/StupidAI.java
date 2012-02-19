package org.away.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.away.model.Itinary;

public class StupidAI implements SuperAI {

	public List<Itinary> bringMeHome(double latitude, double longitude) {
		List<Itinary> itinaries = new ArrayList<Itinary>();
		itinaries.add(new Itinary(2.5, 60 * 35, new int[] { 15 }));
		itinaries.add(new Itinary(0.6, 60 * 15, new int[] { 8, 12 }));
		itinaries.add(new Itinary(2, 60 * 20, new int[] { 32 }));
		itinaries.add(new Itinary(1.25, 60 * 30, new int[] { 2, 4 }));
		return Collections.unmodifiableList(itinaries);
	}

}
