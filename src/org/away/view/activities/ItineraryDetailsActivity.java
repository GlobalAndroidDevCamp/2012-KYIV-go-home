package org.away.view.activities;

import org.away.R;
import org.away.model.Itinary;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ItineraryDetailsActivity extends RoboActivity {

	public static final String ITINERARY_BUNDLE_TAG = "itineraryBundleTag";

	@InjectView(R.id.transportImageView)
	private ImageView transportImage;

	@InjectView(R.id.transportNameTextView)
	private TextView transportName;

	@InjectView(R.id.startStopTextView)
	private TextView startStop;

	@InjectView(R.id.listOfStopsTextView)
	private TextView listOfStops;

	@InjectView(R.id.endStopTextView)
	private TextView endStop;

	private Itinary itinerary;

	@InjectView(R.id.timeTextView)
	private TextView timeTextView;

	@InjectView(R.id.priceTextView)
	private TextView priceTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.itinerary_details_activity);
		loadItineraryFromBundle(this.getIntent().getExtras());
	}

	private void loadItineraryFromBundle(Bundle bundle) {
		if (bundle == null) {
			Log.e("aWay", "Itinerary bundle is NULL");
			return;
		}

		itinerary = (Itinary) bundle.get(ITINERARY_BUNDLE_TAG);
		setItinerary(itinerary);
	}

	private void setItinerary(Itinary itinerary) {

		String namePart = "";
		switch (itinerary.getTransportIds().get(0).getType()) {
		case TRAM:
			transportImage.setImageDrawable(this.getResources().getDrawable(
					R.drawable.tram));
			namePart = "Трамвай №";
			break;
		case TROLLEY:
			transportImage.setImageDrawable(this.getResources().getDrawable(
					R.drawable.trolleybus));
			namePart = "Тролейбус №";
			break;
		case BUS:
		default:
			transportImage.setImageDrawable(this.getResources().getDrawable(
					R.drawable.bus));
			namePart = "Автобус №";
			break;
		}

		timeTextView.setText(setValueWithDefault(itinerary.getSeconds() / 60
				+ " хв.", "Час: "));

		priceTextView.setText(setValueWithDefault(itinerary.getPrice() / 100
				+ " грн.", "Вартість: "));

		transportName.setText(namePart
				+ itinerary.getTransportIds().get(0).getName());
		startStop.setText(itinerary.getRoutes().get(0).getSname());
		endStop.setText(itinerary.getRoutes()
				.get(itinerary.getRoutes().size() - 1).getSname());

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < itinerary.getRoutes().size() - 1; i++) {
			sb.append(itinerary.getRoutes().get(i).getSname()).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		listOfStops.setText(sb.toString());

	}

	private String setValueWithDefault(Object value, String defaultValue) {
		return (value == null) ? defaultValue : defaultValue + " "
				+ value.toString();
	}

}
