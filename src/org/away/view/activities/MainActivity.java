package org.away.view.activities;

import java.io.IOException;

import org.away.R;
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

	// Views
	@InjectView(R.id.searchButton)
	private Button searchButton;
	@InjectView(R.id.startAddressTextBox)
	private TextView startAddressTextBox;

	@Inject
	private GeoCodingService geoService;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		init();
		initLayout();
	}

	private void initLayout() {
		setContentView(R.layout.main_activity_layout);
		
		startAddressTextBox.setText("L'viv, L'vivs'ka oblast, Ukraine");

		searchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				searchButtonClicked();
			}
		});
	}

	private void init() {
		geoService = new GeoCodingService(this);
	}

	private void searchButtonClicked() {
		GeoCoordinates text = null;
		try {
			text = geoService.getGeoCoordinatesByAddress(startAddressTextBox
					.getText().toString());
		} catch (IOException e) {
			Log.e("aWay", e.getMessage());
		}
		Toast.makeText(getApplicationContext(), ""+text,
				Toast.LENGTH_SHORT).show();
	}

}