package org.away.view.activities;

import java.io.IOException;

import org.away.R;
import org.away.ai.SuperAI;
import org.away.controller.GeoCodingService;
import org.away.controller.GeoCodingService.GeoCoordinates;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
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

	@Inject
	private SuperAI ai;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		init();
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

	private void init() {
		//geoService = new GeoCodingService(this);
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

			return;
		}

		// String text = startCoordinates == null ? "Bad location name"
		// : startCoordinates.toString();
		// Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
		// .show();

	}

}