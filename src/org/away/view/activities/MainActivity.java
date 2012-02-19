package org.away.view.activities;

import java.io.IOException;

import org.away.R;
import org.away.controller.GeoCodingService;
import org.away.controller.GeoCodingService.GeoCoordinates;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.inject.Inject;

public class MainActivity extends RoboActivity {

	// ====== Views
	@InjectView(R.id.searchButton)
	private Button searchButton;

	@InjectView(R.id.startAddressTextBox)
	private TextView startAddressTextBox;

	@InjectView(R.id.endAddressTextArea)
	private TextView endAddressTextBox;

	// ====== Services
	@Inject
	private GeoCodingService geoService;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initLayout();
	}

	private void initLayout() {
		setContentView(R.layout.main_activity_layout);

		startAddressTextBox.setText("160 Riverside Drive, New York, New York");

		searchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				searchButtonClicked();
			}
		});
	}

	private void searchButtonClicked() {

		GeoCoordinates startCoordinates = null;
		GeoCoordinates endCoordinates = null;

		try {
			startCoordinates = geoService
					.getGeoCoordinatesByAddress(startAddressTextBox.getText()
							.toString());
			endCoordinates = geoService
					.getGeoCoordinatesByAddress(endAddressTextBox.getText()
							.toString());

		} catch (IOException e) {
			Log.e("aWay", e.getMessage());
			Toast.makeText(getApplicationContext(), e.getMessage(),
					Toast.LENGTH_SHORT).show();

			// return;
		}

		startCoordinates = new GeoCoordinates(24.0845, 49.823);
		endCoordinates = new GeoCoordinates(23.99855, 49.80672);

		startSearchResultsActivity(this, startCoordinates, endCoordinates);

	}

	private void startSearchResultsActivity(MainActivity mainActivity,
			GeoCoordinates startCoordinates, GeoCoordinates endCoordinates) {

		Intent myIntent = new Intent(MainActivity.this,
				SearchResultActivity.class);

		Bundle bundle = new Bundle();
		bundle.putSerializable(SearchResultActivity.GEO_START_BUNDLE_TAG,
				startCoordinates);
		bundle.putSerializable(SearchResultActivity.GEO_END_BUNDLE_TAG,
				endCoordinates);

		myIntent.putExtras(bundle);
		this.startActivity(myIntent);
	}

}