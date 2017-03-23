package com.sixtyfourthpixel.buzzardweather.interactors.responses;


import com.sixtyfourthpixel.buzzardweather.model.local.MultiDayForecast;

public class MultiDayForecastResponse {
	private final MultiDayForecast multiDayForecast;
	private final Throwable error;

	public MultiDayForecastResponse(MultiDayForecast multiDayForecast) {
		this.multiDayForecast = multiDayForecast;
		this.error = null;
	}

	public MultiDayForecastResponse(Throwable error) {
		this.multiDayForecast = null;
		this.error = error;
	}

	public MultiDayForecast getMultiDayForecast() {
		return multiDayForecast;
	}

	public Throwable getError() {
		return error;
	}
}
