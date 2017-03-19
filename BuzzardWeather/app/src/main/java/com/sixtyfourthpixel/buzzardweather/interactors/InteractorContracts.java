package com.sixtyfourthpixel.buzzardweather.interactors;


import com.sixtyfourthpixel.buzzardweather.model.local.MultiDayForecast;

import io.reactivex.Observable;


public interface InteractorContracts {
	interface WeatherApi {
		Observable<MultiDayForecast> getForecast(String city);
	}
}
