package org.away.ai;

import java.util.List;

import org.away.model.Itinary;

public interface SuperAI {
	List<Itinary> bringMeHome(double latitude, double longitude);
}
