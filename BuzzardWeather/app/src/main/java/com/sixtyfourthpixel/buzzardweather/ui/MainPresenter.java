package com.sixtyfourthpixel.buzzardweather.ui;


import android.util.Log;

import com.sixtyfourthpixel.buzzardweather.interactors.InteractorContracts;
import com.sixtyfourthpixel.buzzardweather.model.local.MultiDayForecast;

import static com.sixtyfourthpixel.buzzardweather.Constants.CITY;

public class MainPresenter implements MainContracts.Presenter {
	private static final String TAG = MainPresenter.class.getSimpleName();

	private final InteractorContracts.WeatherApi weatherApi;

	private MainContracts.View view;

	public MainPresenter(InteractorContracts.WeatherApi weatherApi) {
		this.weatherApi = weatherApi;
	}

	@Override
	public void attachView(MainContracts.View view) {
		this.view = view;
	}

	@Override
	public void loadData() {
		weatherApi.getForecast(CITY)
				.doOnNext(this::onReceivedForecast)
				.doOnError(throwable -> onErrorRetrievingForecast())
				.subscribe();
	}

	private void onReceivedForecast(MultiDayForecast forecast) {
		if (view != null && forecast != null) {
			view.onDataLoaded(forecast);
		}
	}

	private void onErrorRetrievingForecast() {
		Log.w(TAG, "Error retrieving forecast data");
	}
}
