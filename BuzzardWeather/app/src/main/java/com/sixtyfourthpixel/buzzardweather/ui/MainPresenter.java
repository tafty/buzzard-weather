package com.sixtyfourthpixel.buzzardweather.ui;


import com.sixtyfourthpixel.buzzardweather.interactors.InteractorContracts;
import com.sixtyfourthpixel.buzzardweather.interactors.responses.MultiDayForecastResponse;
import com.sixtyfourthpixel.buzzardweather.model.local.MultiDayForecast;

import static com.sixtyfourthpixel.buzzardweather.Constants.CITY;

public class MainPresenter implements MainContracts.Presenter {
	@SuppressWarnings("unused")
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
				.subscribe();
	}

	private void onReceivedForecast(MultiDayForecastResponse response) {
		if (view != null && response != null) {
			MultiDayForecast multiDayForecast = response.getMultiDayForecast();

			if (multiDayForecast != null) {
				view.onDataLoaded(response.getMultiDayForecast());
			} else if (response.getError() != null) {
				onErrorRetrievingForecast(response.getError());
			}
		}
	}

	private void onErrorRetrievingForecast(Throwable error) {
		view.showError("Error retrieving forecast data: " + error.getMessage());
	}
}
