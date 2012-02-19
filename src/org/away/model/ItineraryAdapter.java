package org.away.model;

import java.util.ArrayList;
import java.util.List;

import org.away.view.components.ItineraryView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ItineraryAdapter extends BaseAdapter {

	// private int selectedPossition;
	private List<Itinary> itineraries = new ArrayList<Itinary>();

	public ItineraryAdapter(Context context, List<Itinary> objects) {
		this.itineraries = objects;
	}

	@Override
	public int getCount() {
		return itineraries.size();
	}

	@Override
	public Object getItem(int i) {
		return itineraries.get(i);
	}

	@Override
	public long getItemId(int i) {
		return itineraries.get(i).hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null)
			return new ItineraryView(parent.getContext(),
					itineraries.get(position));
		else {
			((ItineraryView) convertView).setItinerary(itineraries
					.get(position));
			return convertView;
		}
	}
}
