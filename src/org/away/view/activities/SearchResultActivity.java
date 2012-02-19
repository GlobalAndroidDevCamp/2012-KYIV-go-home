package org.away.view.activities;

import java.util.ArrayList;
import java.util.List;

import org.away.R;
import org.away.controller.GeoCodingService.GeoCoordinates;
import org.away.controller.SuperAI;
import org.away.model.Itinary;
import org.away.model.ItineraryAdapter;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.inject.Inject;

public class SearchResultActivity extends RoboActivity {

	public static final String GEO_START_BUNDLE_TAG = "startGeoPoint";
	public static final String GEO_END_BUNDLE_TAG = "endGeoPoint";

	@InjectView(R.id.list)
	private ListView searchResultListView;

	@Inject
	private SuperAI ai;

	private ItineraryAdapter itineraryAdapter;
	private List<Itinary> itineraries = new ArrayList<Itinary>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initLayout();
		loadGeoPointFromBundleAndStartSearch(this.getIntent().getExtras());
	}

	private void loadGeoPointFromBundleAndStartSearch(Bundle bundle) {
		if (bundle == null) {
			Log.e("aWay", "Itinerary bundle is NULL");
			return;
		}

		GeoCoordinates startCoordinate = (GeoCoordinates) bundle
				.get(GEO_START_BUNDLE_TAG);
		GeoCoordinates endGeoCoordinates = (GeoCoordinates) bundle
				.get(GEO_END_BUNDLE_TAG);

		List<Itinary> foundItineraries = ai.bringMeHome(startCoordinate,
				endGeoCoordinates);

		if ((foundItineraries == null) || (foundItineraries.isEmpty())) {
			Toast.makeText(this,
					"Поядкуйте Садовому, що не зможете добратися до дому :)",
					Toast.LENGTH_SHORT).show();
		} else {
			itineraries.clear();
			itineraries.addAll(foundItineraries);
			itineraryAdapter.notifyDataSetChanged();
		}
	}

	private void initLayout() {
		setContentView(R.layout.search_result_activity_layout);
		itineraryAdapter = new ItineraryAdapter(getApplicationContext(),
				itineraries);
		searchResultListView.setAdapter(itineraryAdapter);
	}

}
