package com.sixtyfourthpixel.buzzardweather.interactors;


import com.sixtyfourthpixel.buzzardweather.interactors.responses.MultiDayForecastResponse;

import io.reactivex.Observable;


public interface InteractorContracts {
	interface WeatherApi {
		Observable<MultiDayForecastResponse> getForecast(String city);
	}
}
