package org.away.view.components;

import org.away.R;
import org.away.model.Itinary;
import org.away.model.Route;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItineraryView extends LinearLayout {

	@InjectView(R.id.numbersTextView)
	private TextView numbersTextView;

	@InjectView(R.id.timeTextView)
	private TextView timeTextView;

	@InjectView(R.id.priceTextView)
	private TextView priceTextView;

	public ItineraryView(Context context, Itinary itinerary) {
		super(context);

		((RoboActivity) context).getInjector().injectMembers(this);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		inflater.inflate(R.layout.itineraty_row_layout, this, true);

		setItinerary(itinerary);
	}

	public void setItinerary(Itinary itinerary) {
		StringBuilder routes = new StringBuilder();
		for (Route route : itinerary.getRoutes()) {
			routes.append(route.getRname()).append(" - ");
		}
		routes.delete(routes.length() - 3, routes.length());
		numbersTextView.setText(setValueWithDefault(routes,
				"Помилка в обчисленні маршруту"));

		timeTextView.setText(setValueWithDefault(itinerary.getSeconds() / 60
				+ " хв.", "Час: "));

		priceTextView.setText(setValueWithDefault(itinerary.getPrice() / 100
				+ " грн.", "Вартість: "));

	}

	private String setValueWithDefault(Object value, String defaultValue) {
		return (value == null) ? defaultValue : defaultValue + " "
				+ value.toString();
	}

}
