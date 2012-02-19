package org.away.view.components;

import org.away.R;
import org.away.model.Itinary;
import org.away.model.Station;
import org.away.model.Transport;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItineraryView extends LinearLayout {

	private TextView numbersTextView;

	private TextView timeTextView;

	private TextView priceTextView;

	public ItineraryView(Context context, Itinary itinerary) {
		super(context);

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.itineraty_row_layout, this, true);

		initLayout();

		setItinerary(itinerary);
	}

	private void initLayout() {
		numbersTextView = (TextView) findViewById(R.id.numbersTextView);
		priceTextView = (TextView) findViewById(R.id.priceTextView);
		timeTextView = (TextView) findViewById(R.id.timeTextView);
	}

	public void setItinerary(Itinary itinerary) {
		StringBuilder routes = new StringBuilder();
		for (Transport transport : itinerary.getTransportIds()) {
			routes.append(transport.getName()).append(" - ");
		}
		routes.delete(routes.length() - 3, routes.length());
		
		numbersTextView.setText(routes.toString());

		timeTextView.setText(setValueWithDefault(itinerary.getSeconds() / 60
				+ " хв.", "„ас: "));

		priceTextView.setText(setValueWithDefault(itinerary.getPrice() / 100
				+ " грн.", "¬арт≥сть: "));

	}

	private String setValueWithDefault(Object value, String defaultValue) {
		return (value == null) ? defaultValue : defaultValue + " "
				+ value.toString();
	}

}
