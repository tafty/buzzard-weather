package com.sixtyfourthpixel.buzzardweather.ui;


import com.sixtyfourthpixel.buzzardweather.model.local.MultiDayForecast;

public interface MainContracts {
	interface View {
		void onDataLoaded(MultiDayForecast forecast);

		void showError(String message);
	}

	interface Presenter {
		void attachView(View view);

		void loadData();
	}
}
